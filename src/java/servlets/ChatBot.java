package servlets;

import clases.Chat;
import clases.Mensaje;
import clases.Bot;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import java.text.Normalizer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ChatBot extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String archXML = "D:/Chat.xml";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String error = "";
        String borrar = request.getParameter("borrar");
        String texto = request.getParameter("texto");
        String fecha = request.getParameter("fecha");
        String autor = request.getParameter("autor");
        // error += texto + fecha + autor;
        Chat chat = new Chat();
        Bot bot = (Bot) request.getSession().getAttribute("bot");
        chat.cantidad = 0;
        try {
            if (bot == null) {
                System.out.println("Probando");
                bot = new Bot();
            } else {
                System.out.println("Prueba 2");
            }
            // String archXML = "http://localhost:8080/ProyectoProgra3/Chat.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(archXML);
            // Node mensajes = doc.getFirstChild();
            if (borrar != null && borrar.equals("si")) {
                Node chatTag = doc.getFirstChild();
                while (chatTag.hasChildNodes()) {
                    chatTag.removeChild(chatTag.getFirstChild());
                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(archXML));
                transformer.transform(source, result);
                agregarMensaje("Hola MI NOMBRE ES NEO y es un gusto atenderte! <br /> Bienvenido a GuateRapid, ¿qué deseas ordenar?", new Date().getTime() + "", "0");
                bot = null;
            }
            if (texto != null && fecha != null && autor != null) { // Se ejecuta si hay un nuevo mensaje
                agregarMensaje(texto, fecha, autor);
                String mensaje = quitarAcentos(texto);
                agregarMensaje(bot.responder(mensaje), new Date().getTime() + "", "0");
            }
            NodeList mensajes = doc.getElementsByTagName("mensaje");
            for (int i = 0; i < mensajes.getLength(); i++) {
                Node mensaje = mensajes.item(i);
                if (mensaje.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) mensaje;
                    NodeList campos = e.getChildNodes();
                    Mensaje men = new Mensaje();
                    for (int j = 0; j < campos.getLength(); j++) {
                        Node hijo = campos.item(j);
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            if (hijo.getNodeName() == "texto") {
                                men.mensaje = hijo.getTextContent();
                            } else if (hijo.getNodeName() == "fecha") {
                                men.fecha = new Date(Long.parseLong(hijo.getTextContent()));
                            } else if (hijo.getNodeName() == "autor") {
                                men.autor = Integer.parseInt(hijo.getTextContent());
                            }
                        }
                    }
                    chat.mensajes.add(men);
                    chat.cantidad++;
                }
            }
        } catch (ParserConfigurationException pce) {
            error += "Error 1" + pce;
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            error += "Error 2" + ioe;
            ioe.printStackTrace();
        } catch (SAXException sae) {
            error += "Error 3" + sae;
            sae.printStackTrace();
        }
        request.getSession().setAttribute("error", error);
        // chat.mensajes.add(new Mensaje("Bienvenido, ¿qué deseas ordenar?", new Date(), 0));
        // chat.setCantidad(1);
        request.getSession().setAttribute("chat", chat);
        request.getSession().setAttribute("bot", bot);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void agregarMensaje(String texto, String fecha, String autor) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(archXML);
            Node chat = doc.getFirstChild();
            Element mensaje = doc.createElement("mensaje");

            Element textoE = doc.createElement("texto");
            textoE.appendChild(doc.createTextNode(texto));

            Element fechaE = doc.createElement("fecha");
            fechaE.appendChild(doc.createTextNode(fecha));

            Element autorE = doc.createElement("autor");
            autorE.appendChild(doc.createTextNode(autor));

            mensaje.appendChild(textoE);
            mensaje.appendChild(fechaE);
            mensaje.appendChild(autorE);
            chat.appendChild(mensaje);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archXML));
            transformer.transform(source, result);
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
    }

    public static String quitarAcentos(String cadena) {
        String limpio = null;
        if (cadena != null) {
            // Normalizar texto para eliminar acentos, dieresis, cedillas y tildes
            limpio = Normalizer.normalize(cadena, Normalizer.Form.NFD);
            // Quitar caracteres no ASCII excepto la ñ, interrogacion que abre, exclamacion que abre, grados, U con dieresis.
            limpio = limpio.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        }
        return limpio.toLowerCase();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
