<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Overall Report</title>
</head>
<body>
    <h1>Overall Carbon Consumption Report</h1>
    <form action="/api/modules/overall" method="get">
        <label for="username">Enter Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <button type="submit">Get Report</button>
    </form>
    <br>
    <a href="/dashboard-mbip">Back to Dashboard</a>
</body>
</html>
