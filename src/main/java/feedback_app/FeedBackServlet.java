package feedback_app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/feedback")
public class FeedBackServlet extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/servlets?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = ""; // Update if you have a password

    private static final String INSERT_FEEDBACK_SQL = "INSERT INTO feedback (email, phone, feedback) VALUES (?, ?, ?)";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String phone = req.getParameter("PhoneNumber");
        String feedback = req.getParameter("feedbackMessage");

        // Set a response content type
        resp.setContentType("text/html");
        
        String alertMessage; // Variable to hold feedback message
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            alertMessage = "Error: MySQL JDBC Driver not found!";
            showAlert(resp, alertMessage);
            return;
        }

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
             PreparedStatement stmt = conn.prepareStatement(INSERT_FEEDBACK_SQL)) {

            stmt.setString(1, email);
            stmt.setString(2, phone);
            stmt.setString(3, feedback);

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                alertMessage = "Feedback submitted successfully!";
            } else {
                alertMessage = "Failed to submit feedback. Please try again.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            alertMessage = "Error: " + e.getMessage();
        }

        // Redirect back to the original page with an alert
        showAlert(resp, alertMessage);
    }

    private void showAlert(HttpServletResponse resp, String message) throws IOException {
        PrintWriter pw = resp.getWriter();
        pw.print("<html><head><title>Feedback</title></head><body>");
        pw.print("<script>alert('" + message + "');</script>");
        pw.print("<script>window.history.back();</script>"); // Redirect back to the previous page
        pw.print("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
