<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Water Consumption</title>
    <script>
        function submitWaterForm(event) {
            event.preventDefault();

            const form = document.getElementById("waterForm");
            const formData = new FormData(form);

            fetch(form.action, {
                method: "POST",
                body: formData
            })
            .then(response => response.text())
            .then(message => {
                alert(message);
                window.location.href = "/dashboard-participant";
            })
            .catch(error => {
                console.error("Error submitting data:", error);
                alert("Failed to submit water data. Please try again.");
            });
        }
    </script>
</head>
<body>
    <h1>Submit Water Consumption Data</h1>
    <form id="waterForm" action="/api/modules/water" method="post" onsubmit="submitWaterForm(event)">
        <label for="waterUsed">Water Used (liters):</label>
        <input type="number" id="waterUsed" name="waterUsed" step="0.01" required>
        <br>
        <label for="submissionDate">Submission Date:</label>
        <input type="date" id="submissionDate" name="submissionDate" required>
        <br>
        <button type="submit">Submit</button>
    </form>
    <br>
    <a href="/dashboard-participant">Back to Dashboard</a>
</body>
</html>
