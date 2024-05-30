package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.annotation.Controller;
import com.annotation.Get;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Mapping;

public class FrontController extends HttpServlet {

    private Map<String, Mapping> urls;
    private List<Class<?>> controllers;
    private String _package;

    public void init() throws ServletException {
        try {
            String p = this.getInitParameter("app.controllers.packageName").replace(".", "/");
            this._package = p;
            this.urls = new HashMap<>();
            this.controllers = new ArrayList<>();
            this.scan();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void scan() throws ClassNotFoundException {
        if (this._package == null || this._package.isEmpty()) {
            throw new ClassNotFoundException("Controller package not specified");
        }
        File directory = new File(getServletContext().getRealPath("/WEB-INF/classes/" + this._package));
        if (!directory.exists() || !directory.isDirectory()) {
            throw new ClassNotFoundException("Controller Package \"" + this._package + "\" not Found");
        }
        scan_Find_Classes(this._package, directory);
    }

    protected void scan_Find_Classes(String packageName, File directory) throws ClassNotFoundException {
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                scan_Find_Classes(packageName + "." + file.getName(), file);
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(Controller.class)) {
                    Method[] methods = clazz.getDeclaredMethods();
                    this.controllers.add(clazz);
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(Get.class)) {
                            this.urls.put(method.getAnnotation(Get.class).url(),
                                    new Mapping(method.getName(), clazz.getName()));
                        }
                    }
                }
            }
        }
    }

    protected void processrequest(HttpServletRequest req, HttpServletResponse resp) {
        PrintWriter out = null;
        String context_path = req.getContextPath();
        String uri = req.getRequestURI();

        try {
            out = resp.getWriter();
            String path = uri.replace(context_path, "");
            Mapping m = this.urls.get(path);

            if (m != null) {
                Class<?> clazz = Class.forName(m.getClassName());
                Object instance = clazz.getDeclaredConstructor().newInstance();
                Method method = clazz.getDeclaredMethod(m.getMethod());
                Object result = method.invoke(instance);
                out.println(result.toString());
            } else {
                out.println("No mapping found for this URL.");
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processrequest(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processrequest(req, resp);
    }
}
