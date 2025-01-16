<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Participant Dashboard</title>
    <script>
        // Function to fetch emissions data and update the UI
        function fetchEmissions(endpoint, elementId) {
            fetch(endpoint)
                .then(response => response.json())
                .then(data => {
                    document.getElementById(elementId).textContent = data.toFixed(2) + " kg CO2";
                })
                .catch(error => {
                    console.error("Error fetching emissions data:", error);
                    document.getElementById(elementId).textContent = "Error";
                });
        }

        // Fetch emissions data for all modules when the page loads
        window.onload = function () {
            fetchEmissions('/api/modules/waste/summary', 'waste-emissions');
            fetchEmissions('/api/modules/water/summary', 'water-emissions');
            fetchEmissions('/api/modules/car/summary', 'car-emissions');
            fetchEmissions('/api/modules/electricity/summary', 'electricity-emissions');
        };
    </script>
</head>
<body>
    <h1>Participant Dashboard</h1>

    <h2>Monthly Carbon Emissions:</h2>
    <ul id="monthly-emissions">
        <li>Waste: <span id="waste-emissions">Loading...</span></li>
        <li>Water: <span id="water-emissions">Loading...</span></li>
        <li>Car: <span id="car-emissions">Loading...</span></li>
        <li>Electricity: <span id="electricity-emissions">Loading...</span></li>
    </ul>

    <h3>Submit Data:</h3>
    <ul>
        <li><a href="/waste_management">Submit Waste Management Data</a></li>
        <li><a href="/water_consumption">Submit Water Consumption Data</a></li>
        <li><a href="/car_emissions">Submit Car Emissions Data</a></li>
        <li><a href="/electrical_consumption">Submit Electrical Consumption Data</a></li>
    </ul>

    <h3>Logout:</h3>
    <a href="/logout">Logout</a>
</body>
</html>
