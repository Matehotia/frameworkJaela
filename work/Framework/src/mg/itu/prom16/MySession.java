package mg.itu.prom16;

import jakarta.servlet.http.HttpSession;

public class MySession {
    private HttpSession session;

    public MySession(HttpSession session) {
        this.session = session;
    }

    public Object get(String key) {
        return session.getAttribute(key);
    }

    public void add(String key, Object object) {
        session.setAttribute(key, object);
    }

    public void delete(String key) {
        session.removeAttribute(key);
    }

    public void update(String key, Object object) {
        session.setAttribute(key, object);
    }

    public HttpSession getSession() {
        return session;
    }
}
