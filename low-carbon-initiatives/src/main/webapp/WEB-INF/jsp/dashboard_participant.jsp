<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Participant Dashboard</title>
    <script>
        async function fetchMonthlySummaries() {
            try {
                const username = document.getElementById("username").textContent;
    
                const wasteResponse = await fetch(`/api/modules/waste/summary?username=${username}`);
                const waterResponse = await fetch(`/api/modules/water/summary?username=${username}`);
                const carResponse = await fetch(`/api/modules/car/summary?username=${username}`);
                const electricityResponse = await fetch(`/api/modules/electricity/summary?username=${username}`);
    
                const wasteSummary = await wasteResponse.json();
                const waterSummary = await waterResponse.json();
                const carSummary = await carResponse.json();
                const electricitySummary = await electricityResponse.json();
    
                document.getElementById("wasteSummary").innerText = `Waste: ${wasteSummary.toFixed(2)} kg CO2`;
                document.getElementById("waterSummary").innerText = `Water: ${waterSummary.toFixed(2)} kg CO2`;
                document.getElementById("carSummary").innerText = `Car: ${carSummary.toFixed(2)} kg CO2`;
                document.getElementById("electricitySummary").innerText = `Electricity: ${electricitySummary.toFixed(2)} kg CO2`;
    
                const totalEmissions = wasteSummary + waterSummary + carSummary + electricitySummary;
                document.getElementById("totalSummary").innerText = `Total Carbon Emissions This Month: ${totalEmissions.toFixed(2)} kg CO2`;
            } catch (error) {
                console.error("Error fetching monthly summaries:", error);
            }
        }
    
        document.addEventListener("DOMContentLoaded", fetchMonthlySummaries);
    </script>
</head>
<body>
    <h1>Participant Dashboard</h1>

    <!-- Summary Section -->
    <div id="carbonEmissionsSummary">
        <h3>Monthly Carbon Emissions:</h3>
        <ul>
            <li id="wasteSummary">Loading...</li>
            <li id="waterSummary">Loading...</li>
            <li id="carSummary">Loading...</li>
            <li id="electricitySummary">Loading...</li>
        </ul>
        <h4 id="totalSummary">Calculating Total...</h4>
    </div>

    <!-- Links to Submit Data -->
    <ul>
        <li><a href="/waste_management">Submit Waste Management Data</a></li>
        <li><a href="/water_consumption">Submit Water Consumption Data</a></li>
        <li><a href="/car_emissions">Submit Car Emissions Data</a></li>
        <li><a href="/electrical_consumption">Submit Electrical Consumption Data</a></li>
    </ul>
    <a href="/logout">Logout</a>
</body>
</html>
