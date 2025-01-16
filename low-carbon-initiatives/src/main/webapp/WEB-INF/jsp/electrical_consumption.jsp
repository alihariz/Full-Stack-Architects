<!--<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Electrical Consumption</title>
    <script>
        function showSuccessMessage() {
            alert("Electricity data submitted successfully!");
            window.location.href = "/dashboard-participant";
        }
    </script>
</head>
<body>
    <h1>Submit Electrical Consumption Data</h1>
    <form action="/api/modules/electricity" method="post" onsubmit="showSuccessMessage(); return false;">
        <label for="electricityUsed">Electricity Used (kWh):</label>
        <input type="number" id="electricityUsed" name="electricityUsed" step="0.01" required>
        <br>
        <label for="submissionDate">Submission Date:</label>
        <input type="date" id="submissionDate" name="submissionDate" required>
        <br>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <button type="submit">Submit</button>
    </form>
    <br>
    <a href="/dashboard-participant">Back to Dashboard</a>
</body>
</html>
-->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Waste Management</title>
    <script>
        function submitElectricalForm(event) {
            event.preventDefault();

            const form = document.getElementById("electricalForm");
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
                alert("Failed to submit electrical data. Please try again.");
            });
        }
    </script>
</head>
<body>
    <h1>Submit Electrical Consumption Data</h1>
    <form id="electricalForm" action="/api/modules/electricity" method="post" onsubmit="submitElectricalForm(event)">
        <label for="electricityUsed">Electricity Used (kWh):</label>
        <input type="number" id="electricityUsed" name="electricityUsed" step="0.01" required>
        <br>
        <label for="submissionDate">Submission Date:</label>
        <input type="date" id="submissionDate" name="submissionDate" required>
        <br>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <button type="submit">Submit</button>
    </form>
    <br>
    <a href="/dashboard-participant">Back to Dashboard</a>
</body>
</html>
