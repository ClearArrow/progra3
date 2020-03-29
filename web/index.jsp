<%-- 
    Document   : index
    Created on : 21/03/2020, 08:21:57 AM
    Author     : José
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordenar comida</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.2/css/all.css" rel="stylesheet" />
        <link href="./css/styles.css" rel="stylesheet" />
    </head>

    <body>
        <div class="container mt-5">
            <h3 class="text-center">Pedir comida rápida</h3>
            <div class="chat">
                <div class="mensajeria">
                    <div class="mensajes">
                        <div class="historial">
                            <div class="bot">
                                <div class="img_bot"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                                <div class="recibido">
                                    <div class="men_recibido">
                                        <p>Test which is a new approach to have all
                                            solutions</p>
                                        <span class="fecha"> 11:01 AM    |    June 9</span></div>
                                </div>
                            </div>
                            <div class="enviado">
                                <div class="men_enviado">
                                    <p>Test which is a new approach to have all
                                        solutions</p>
                                    <span class="fecha"> 11:01 AM    |    June 9</span> </div>
                            </div>
                            <div class="bot">
                                <div class="img_bot"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                                <div class="recibido">
                                    <div class="men_recibido">
                                        <p>Test, which is a new approach to have</p>
                                        <span class="fecha"> 11:01 AM    |    Yesterday</span></div>
                                </div>
                            </div>
                            <div class="enviado">
                                <div class="men_enviado">
                                    <p>Apollo University, Delhi, India Test</p>
                                    <span class="fecha"> 11:01 AM    |    Today</span> </div>
                            </div>
                            <div class="bot">
                                <div class="img_bot"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                                <div class="recibido">
                                    <div class="men_recibido">
                                        <p>We work directly with our designers and suppliers,
                                            and sell direct to you, which means quality, exclusive
                                            products, at a price anyone can afford.</p>
                                        <span class="fecha"> 11:01 AM    |    Today</span></div>
                                </div>
                            </div>
                        </div>
                        <div class="texto">
                            <div class="escribir">
                                <input type="text" class="caja_texto" placeholder="Type a message" />
                                <button class="boton_enviar" type="button"><i class="fas fa-paper-plane" aria-hidden="true"></i></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="./js/jquery-3.4.1.min.js"></script>
        <script src="./js/popper.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/main.js"></script>
    </body>

</html>