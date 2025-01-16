<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Emissions</title>
</head>
<body>
    <h1>Submit Car Emissions Data</h1>
    <form action="/api/modules/car" method="post">
        <label for="distanceDriven">Distance Driven (km):</label>
        <input type="number" id="distanceDriven" name="distanceDriven" step="0.01" required>
        <br>
        <label for="fuelEfficiency">Fuel Efficiency (km/l):</label>
        <input type="number" id="fuelEfficiency" name="fuelEfficiency" step="0.01" required>
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
