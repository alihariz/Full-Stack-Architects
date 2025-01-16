<!--<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Emissions</title>
    <script>
        function showSuccessMessage() {
            alert("Car data submitted successfully!");
            window.location.href = "/dashboard-participant";
        }
    </script>
</head>
<body>
    <h1>Submit Car Emissions Data</h1>
    <form action="/api/modules/car" method="post" onsubmit="showSuccessMessage(); return false;">
        <label for="distanceDriven">Distance Driven (km):</label>
        <input type="number" id="distanceDriven" name="distanceDriven" step="0.01" required>
        <br>
        <label for="fuelEfficiency">Fuel Efficiency (km/l):</label>
        <input type="number" id="fuelEfficiency" name="fuelEfficiency" step="0.01" required>
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
    <title>Car Emissions</title>
    <script>
        function submitCarForm(event) {
            event.preventDefault();

            const form = document.getElementById("carForm");
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
                alert("Failed to submit car data. Please try again.");
            });
        }
    </script>
</head>
<body>
    <h1>Submit Car Emission Data</h1>
    <form id="carForm" action="/api/modules/car" method="post" onsubmit="submitCarForm(event)">
        <label for="distanceDriven">Distance Driven (km):</label>
        <input type="number" id="distanceDriven" name="distanceDriven" step="0.01" required>
        <br>
        <label for="fuelEfficiency">Fuel Efficiency (km/l):</label>
        <input type="number" id="fuelEfficiency" name="fuelEfficiency" step="0.01" required>
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
