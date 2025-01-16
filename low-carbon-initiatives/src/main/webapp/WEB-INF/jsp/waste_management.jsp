<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Waste Management</title>
    <script>
        function submitWasteForm(event) {
            event.preventDefault();

            const form = document.getElementById("wasteForm");
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
                alert("Failed to submit waste data. Please try again.");
            });
        }
    </script>
</head>
<body>
    <h1>Submit Waste Management Data</h1>
    <form id="wasteForm" action="/api/modules/waste" method="post" onsubmit="submitWasteForm(event)">
        <label for="wasteProduced">Waste Produced (kg):</label>
        <input type="number" id="wasteProduced" name="wasteProduced" step="0.01" required>
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
