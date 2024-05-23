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
                    <main class="bg-white-500 flex-1 p-3 overflow-hidden">

                        <div class="flex flex-col">


                            <!--Grid Form-->

                            <div class="flex flex-1  flex-col md:flex-row lg:flex-row mx-2">
                                <div class="mb-2 border-solid border-gray-300 rounded border shadow-sm w-full">
                                    <div class="bg-gray-200 px-2 py-3 border-solid border-gray-200 border-b">
                                        Thông Tin
                                    </div>
                                    <div class="p-3">
                                        <% if (request.getAttribute("errorMessage") != null) { %>
                                        <div class="error" style="color: red;">
                                            <%= request.getAttribute("errorMessage") %>
                                        </div>
                                        <% } %>

                                        <form class="w-full" action="myaccount" method="post">
                                            <input type="hidden" name="accountID" value="${account.accountID}">

                                            <div class="flex flex-wrap -mx-3 mb-6">
                                                <div class="w-full px-3">
                                                    <label class="block uppercase tracking-wide text-grey-darker text-xs font-light mb-1"
                                                           for="grid-password">
                                                        Name:
                                                    </label>
                                                    <input class="appearance-none block w-full bg-grey-200 text-grey-darker border border-grey-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-grey"
                                                           value="${account.hoVaTen}" name="hoVaTen" type="text">

                                                    <label class="block uppercase tracking-wide text-grey-darker text-xs font-light mb-1"
                                                           for="grid-password">

                                                        Email:
                                                    </label>
                                                    <input class="appearance-none block w-full bg-grey-200 text-grey-darker border border-grey-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-grey"
                                                           value="${account.email}" name="email" type="text">

                                                    <label class="block uppercase tracking-wide text-grey-darker text-xs font-light mb-1"
                                                           for="grid-password">
                                                        CCCD:
                                                    </label>
                                                    <input class="appearance-none block w-full bg-grey-200 text-grey-darker border border-grey-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-grey"
                                                           value="${account.CCCD}" name="CCCD" type="text">

                                                    <label class="block uppercase tracking-wide text-grey-darker text-xs font-light mb-1"
                                                           for="grid-password">
                                                        Address:
                                                    </label>
                                                    <input class="appearance-none block w-full bg-grey-200 text-grey-darker border border-grey-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-grey"
                                                           value="${account.diaChi}" name="diaChi" type="text">
                                                    <label class="block uppercase tracking-wide text-grey-darker text-xs font-light mb-1"
                                                           for="grid-password">
                                                        Password:
                                                    </label>
                                                    <input class="appearance-none block w-full bg-grey-200 text-grey-darker border border-grey-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-grey"
                                                           value="${account.password}" name="password" type="text">


                                                    <button class="bg-green-500 hover:bg-green-800 text-white font-bold py-2 px-4 rounded"  type="submit">
                                                        Save
                                                    </button>
                                                </div>
                                            </div>

                                        </form>
                                    </div>
                                </div>
                            </div>
                            <!--/Grid Form-->
                        </div>
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