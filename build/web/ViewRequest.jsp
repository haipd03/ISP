<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- Css -->
        <link rel="stylesheet" href="./dist/styles.css">
        <link rel="stylesheet" href="./dist/all.css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400i,600,600i,700,700i" rel="stylesheet">
        <title>Forms | Tailwind Admin</title>
    </head>

    <body>
        <!--Container -->
        <div class="mx-auto bg-grey-lightest">
            <!--Screen-->
            <div class="min-h-screen flex flex-col">
                <!--Header Section Starts Here-->
                                <jsp:include page="menu1.jsp" />

                <!--/Header-->

                <div class="flex flex-1">
                    <!--Sidebar-->
                                    <jsp:include page="menu2.jsp" />

                    <!--/Sidebar-->
                    <!--Main-->
                     <main class="bg-white-500 flex-1 p-6 overflow-hidden">
                <div class="flex flex-col justify-center items-center">
                    <!-- Card Section Starts Here -->
                    <div class="mb-4 border-solid border-purple border shadow-lg w-full md:w-3/4 lg:w-1/2 mx-auto">
                        <div class="bg-purple-700 px-4 py-3 border-solid border-purple border-b text-white">
                          View  Request Information
                        </div>
                        <div class="p-4 bg-white">
                            <div class="mb-6">
                                <label class="block text-purple font-regular mb-1">Recipient Email</label>
                                <p class="text-purple-darker leading-tight">sample@example.com</p>
                            </div>
                            <div class="mb-6">
                                <label class="block text-purple font-regular mb-1">Subject</label>
                                <p class="text-purple-darker leading-tight">Sample Subject</p>
                            </div>
                            <div class="mb-6">
                                <label class="block text-purple font-regular mb-1">Message</label>
                                <p class="text-purple-darker leading-tight">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                            </div>
                            <div class="flex justify-between">
                                <a href="Nhaprequest.jsp" class="shadow bg-blue-500 hover:bg-blue-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-6 rounded">Edit</a>
                                <!-- Here you can include a button for further actions -->
                            </div>
                        </div>
                    </div>
                    <!--/ Displaying Request Information -->
                </div>
                <!-- /Card Section Ends Here -->
            </main>
                    <!--/Main-->
                </div>
                <!--Footer-->
                <footer class="bg-grey-darkest text-white p-2">
                    <div class="flex flex-1 mx-auto">&copy; My Design</div>
                </footer>
                <!--/footer-->

            </div>

        </div>

        <script src="./main.js"></script>

    </body>

</html>