<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <title>Login | Tailwind Admin</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./dist/styles.css">
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
          crossorigin="anonymous">
    <style>
        .login {
            background: url('./dist/images/login-new.jpeg');
        }
    </style>
</head>

<body class="h-screen font-sans login bg-cover">
    <div class="container mx-auto h-full flex flex-1 justify-center items-center">
        <div class="w-full max-w-lg">
            <div class="leading-loose">
                <form class="max-w-xl m-4 p-10 bg-white rounded shadow-xl" action="login" method="post">
                    <p class="text-gray-800 font-medium text-center text-lg font-bold">Login</p>

                    <!-- Display error message if 'mess' is not empty -->
                    <c:if test="${not empty mess}">
                        <p class="text-red-500 text-center">${mess}</p>
                    </c:if>

                    <div>
                        <label class="block text-sm text-gray-600" for="username">Username</label>
                        <input class="w-full px-5 py-1 text-gray-700 bg-gray-200 rounded" id="username" name="username"
                               type="text" required="" placeholder="User Name" aria-label="username">
                    </div>
                    <div class="mt-2">
                        <label class="block text-sm text-gray-600" for="password">Password</label>
                        <input class="w-full px-5 py-1 text-gray-700 bg-gray-200 rounded" id="password" name="password"
                               type="password" required="" placeholder="*******" aria-label="password">
                    </div>
                    <div class="mt-4 items-center justify-between">
                        <button class="px-4 py-1 text-white font-light tracking-wider bg-gray-900 rounded"
                                type="submit">Login</button>
                        <a class="inline-block right-0 align-baseline font-bold text-sm text-500 hover:text-blue-800" href="ForgotPassword.jsp">
                            Forgot Password?
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Display alerts based on status -->
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script type="text/javascript">
        document.addEventListener("DOMContentLoaded", function() {
            var status = "${status}";
            if (status == "resetSuccess") {
                swal("Congrats", "Password Reset Successful", "success");
            } else if (status == "resetFailed") {
                swal("Sorry", "Password Reset Failed", "error");
            }
        });
    </script>
</body>

</html>
