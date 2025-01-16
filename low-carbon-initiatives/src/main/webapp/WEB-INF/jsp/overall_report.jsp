<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Overall Report</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        /* Modal styling */
        .modal {
            display: none; 
            position: fixed; 
            z-index: 1; 
            left: 0;
            top: 0;
            width: 100%; 
            height: 100%; 
            overflow: auto; 
            background-color: rgba(0, 0, 0, 0.4); 
            justify-content: center;
            align-items: center;
        }

        .modal-content {
            background-color: #fefefe;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            width: 50%;
            text-align: center;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }

        .close:hover, .close:focus {
            color: black;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <h1>Overall Carbon Consumption Report</h1>
    <form id="reportForm">
        <label for="username">Enter Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <button type="submit">Get Report</button>
    </form>    
    <br>
    <a href="/dashboard-mbip">Back to Dashboard</a>

    <!-- Modal -->
    <div id="reportModal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <p id="reportData">Loading...</p>
            <button id="modalOk">OK</button>
        </div>
    </div>

    <script>
        $(document).ready(function() {
            const modal = $('#reportModal');
            const closeModal = $('.close');
            const reportData = $('#reportData');

            // Close modal
            closeModal.click(function() {
                modal.hide();
            });

            // Close modal on OK button click
            $('#modalOk').click(function() {
                modal.hide();
            });

            // Form submission with AJAX
            $('#reportForm').on('submit', function(e) {
                e.preventDefault(); // Prevent default form submission
                const username = $('#username').val();

                // AJAX call to fetch data
                $.ajax({
                    url: `/api/modules/overall?username=${username}`,
                    method: 'GET',
                    success: function(response) {
                    // Update modal content with fetched data (response is the double returned)
                        reportData.text(`Overall Carbon Consumption: ${response.toFixed(2)}`);
                        modal.show(); // Display the modal
                    },

                    error: function() {
                        reportData.text('Failed to fetch the report. Please try again.');
                        modal.show(); // Display the modal
                    }
                });
            });
        });
    </script>
</body>
</html>
