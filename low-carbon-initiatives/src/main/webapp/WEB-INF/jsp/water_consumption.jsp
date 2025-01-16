<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Water Consumption</title>
</head>
<body>
    <h1>Submit Water Consumption Data</h1>
    <form action="/api/modules/water" method="post">
        <label for="waterUsed">Water Used (liters):</label>
        <input type="number" id="waterUsed" name="waterUsed" step="0.01" required>
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
