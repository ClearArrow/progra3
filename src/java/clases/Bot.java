package clases;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Bot {

    public int totalRespondidas;
    private String archXML = "D:\\Menu.xml";
    private String archXML2 = "D:\\Estructura.xml";
    public ArrayList<ItemMenu> menuCompleto = new ArrayList<ItemMenu>();
    public Opcion estructura;
    public int numOpcion;
    // Para las respuestas
    public String comida;
    public String bebida;
    public String extra;
    public double precio;

    public Bot() {
        this.totalRespondidas = 0;
        this.numOpcion = 0;
        cargarDatos();
    }

    public String responder(String textoUsuario) {
        String respuesta = "";
        if (totalRespondidas == 0) {
            // Opción 1 - el usuario especifica la comida que quiere, else lleva a opción 2
            if (textoUsuario.indexOf("vende ") != -1 || textoUsuario.indexOf("tienen ") != -1 || textoUsuario.indexOf("me das ") != -1 || textoUsuario.indexOf("venden ") != -1 || textoUsuario.indexOf("deme ") != -1 || textoUsuario.indexOf("quiero ") != -1 || textoUsuario.indexOf("quisiera ") != -1 || textoUsuario.indexOf("me da ") != -1 || textoUsuario.indexOf("dame ") != -1 || textoUsuario.indexOf("tiene ") != -1 || textoUsuario.indexOf("me dan ") != -1) {
                if (textoUsuario.indexOf("hamburguesa") != -1) {
                    respuesta += estructura.opcion1.texto + "hamburguesas:<br/>";
                    for (int i = 0; i < menuCompleto.size(); i++) {
                        if (menuCompleto.get(i).id <= 4) {
                            respuesta += "• Hamburguesa " + menuCompleto.get(i).nombre + " Q" + menuCompleto.get(i).precio + "<br/>";
                        }
                    }
                    totalRespondidas++;
                    numOpcion = 1;
                    comida = "hamburguesa";
                } else if (textoUsuario.indexOf("pizza") != -1) {
                    respuesta += estructura.opcion1.texto + "pizzas:<br/>";
                    for (int i = 0; i < menuCompleto.size(); i++) {
                        if (menuCompleto.get(i).id <= 16 && menuCompleto.get(i).id >= 8) {
                            respuesta += "• Pizza " + menuCompleto.get(i).nombre + " Q" + menuCompleto.get(i).precio + "<br/>";
                        }
                    }
                    totalRespondidas++;
                    numOpcion = 1;
                    comida = "pizza";
                } else if (textoUsuario.indexOf("papas") != -1) {
                    respuesta += estructura.opcion1.texto + "papas fritas:<br/>";
                    for (int i = 0; i < menuCompleto.size(); i++) {
                        if (menuCompleto.get(i).id <= 7 && menuCompleto.get(i).id >= 5) {
                            respuesta += "• La " + menuCompleto.get(i).nombre + " Q" + menuCompleto.get(i).precio + "<br/>";
                        }
                    }
                    totalRespondidas++;
                    numOpcion = 1;
                    comida = "papas";
                } else if (textoUsuario.indexOf("pollo") != -1) {
                    respuesta += estructura.opcion1.texto + "pollo:<br/>";
                    for (int i = 0; i < menuCompleto.size(); i++) {
                        if ((menuCompleto.get(i).id <= 18 && menuCompleto.get(i).id >= 17) || menuCompleto.get(i).id == 27) {
                            respuesta += "• " + menuCompleto.get(i).nombre + " Q" + menuCompleto.get(i).precio + "<br/>";
                        }
                    }
                    totalRespondidas++;
                    numOpcion = 1;
                    comida = "pollo";
                } else {
                    respuesta += estructura.opcion2.texto;
                    totalRespondidas++;
                    numOpcion = 2;
                }

            } else if (textoUsuario.indexOf("quiero") != -1 && textoUsuario.indexOf("nada") != -1) {

            } else {
                respuesta += "Disculpa, no te entendí. ¿Puedes repetir?";
            }
        } else if (totalRespondidas == 1) {
            if (numOpcion == 1) {
                if (comida.equals("hamburguesa")) {
                    if (textoUsuario.indexOf("doble") != -1 && textoUsuario.indexOf(" res") != -1) {
                        comida = "la hamburguesa doble de res";
                        precio = menuCompleto.get(2).precio;
                    } else if (textoUsuario.indexOf("doble") != -1 && textoUsuario.indexOf(" pollo") != -1) {
                        comida = "la hamburguesa doble de pollo";
                        precio = menuCompleto.get(3).precio;
                    } else if (textoUsuario.indexOf(" res") != -1) {
                        comida = "la hamburguesa de res";
                        precio = menuCompleto.get(1).precio;
                    } else if (textoUsuario.indexOf(" pollo") != -1) {
                        comida = "la hamburguesa de pollo" + "<br/>";
                        precio = menuCompleto.get(0).precio;
                    }
                    respuesta += estructura.opcion1.opcion1.texto.replace("$1", comida);
                } else if (comida.equals("pizza")) {
                    respuesta += estructura.opcion1.opcion1.texto.replace("$1", comida);
                } else if (comida.equals("papas")) {
                    respuesta += estructura.opcion1.opcion1.texto.replace("$1", comida);
                } else if (comida.equals("pollo")) {
                    respuesta += estructura.opcion1.opcion1.texto.replace("$1", comida);
                }
                for (int i = 0; i < menuCompleto.size(); i++) {
                    if ((menuCompleto.get(i).id <= 24 && menuCompleto.get(i).id >= 19)) {
                        respuesta += "• " + menuCompleto.get(i).nombre + " Q" + menuCompleto.get(i).precio + "<br/>";
                    }
                }
            } else if (numOpcion == 2) {
                if (textoUsuario.indexOf("pollo") != -1 || textoUsuario.indexOf("hamburguesa") != -1 || textoUsuario.indexOf("pizza") != -1 || textoUsuario.indexOf("papas") != -1) {
                    if (textoUsuario.indexOf("hamburguesa") != -1) {
                        respuesta += estructura.opcion1.texto + "hamburguesas:<br/>";
                        for (int i = 0; i < menuCompleto.size(); i++) {
                            if (menuCompleto.get(i).id <= 4) {
                                respuesta += "• Hamburguesa " + menuCompleto.get(i).nombre + " Q" + menuCompleto.get(i).precio + "<br/>";
                            }
                        }
                        // totalRespondidas++;
                        numOpcion = 1;
                        comida = "hamburguesa";
                    } else if (textoUsuario.indexOf("pizza") != -1) {
                        respuesta += estructura.opcion1.texto + "pizzas:<br/>";
                        for (int i = 0; i < menuCompleto.size(); i++) {
                            if (menuCompleto.get(i).id <= 16 && menuCompleto.get(i).id >= 8) {
                                respuesta += "• Pizza " + menuCompleto.get(i).nombre + " Q" + menuCompleto.get(i).precio + "<br/>";
                            }
                        }
                        // totalRespondidas++;
                        numOpcion = 1;
                        comida = "pizza";
                    } else if (textoUsuario.indexOf("papas") != -1) {
                        respuesta += estructura.opcion1.texto + "papas fritas:<br/>";
                        for (int i = 0; i < menuCompleto.size(); i++) {
                            if (menuCompleto.get(i).id <= 7 && menuCompleto.get(i).id >= 5) {
                                respuesta += "• La " + menuCompleto.get(i).nombre + " Q" + menuCompleto.get(i).precio + "<br/>";
                            }
                        }
                        // totalRespondidas++;
                        numOpcion = 1;
                        comida = "papas";
                    } else if (textoUsuario.indexOf("pollo") != -1) {
                        respuesta += estructura.opcion1.texto + "pollo:<br/>";
                        for (int i = 0; i < menuCompleto.size(); i++) {
                            if ((menuCompleto.get(i).id <= 18 && menuCompleto.get(i).id >= 17) || menuCompleto.get(i).id == 27) {
                                respuesta += "• " + menuCompleto.get(i).nombre + " Q" + menuCompleto.get(i).precio + "<br/>";
                            }
                        }
                        // totalRespondidas++;
                        numOpcion = 1;
                        comida = "pollo";
                    }

                } else {
                    respuesta += estructura.opcion2.texto;
                    totalRespondidas = 1;
                    numOpcion = 2;
                }
            }
        }
        return respuesta;
    }

    private void cargarDatos() {
        try { // Cargar menú
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(archXML);
            Node menu = doc.getFirstChild();
            NodeList items = menu.getChildNodes();
            for (int i = 0; i < items.getLength(); i++) {
                Node nodo = items.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) nodo;
                    NodeList campos = e.getChildNodes();
                    ItemMenu item = new ItemMenu();
                    for (int j = 0; j < campos.getLength(); j++) {
                        Node hijo = campos.item(j);
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            if (hijo.getNodeName() == "nombre") {
                                item.nombre = hijo.getTextContent();
                            } else if (hijo.getNodeName() == "precio") {
                                item.precio = Double.parseDouble(hijo.getTextContent());
                            } else if (hijo.getNodeName() == "id") {
                                item.id = Integer.parseInt(hijo.getTextContent());
                            }
                        }
                    }
                    menuCompleto.add(item);
                }
            }
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
        try { // Cargar árbol de respuestas
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(archXML2);
            Node estruct = doc.getFirstChild();
            NodeList opciones = estruct.getChildNodes();
            this.estructura = cargarOpciones(opciones);
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
    }

    private Opcion cargarOpciones(NodeList opciones) {
        Opcion opcion = new Opcion();
        for (int i = 0; i < opciones.getLength(); i++) {
            Node nodo = opciones.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                if (nodo.getNodeName() == "texto") {
                    opcion.texto = nodo.getTextContent();
                } else if (nodo.getNodeName() == "id") {
                    opcion.id = Integer.parseInt(nodo.getTextContent());
                } else if (nodo.getNodeName() == "opcion") {
                    int id = Integer.parseInt(nodo.getAttributes().getNamedItem("id").getNodeValue());
                    switch (id) {
                        case 1:
                            opcion.opcion1 = this.cargarOpciones(nodo.getChildNodes());
                            break;
                        case 2:
                            opcion.opcion2 = this.cargarOpciones(nodo.getChildNodes());
                            break;
                        case 3:
                            opcion.opcion3 = this.cargarOpciones(nodo.getChildNodes());
                            break;
                        case 4:
                            opcion.opcion4 = this.cargarOpciones(nodo.getChildNodes());
                            break;
                        case 5:
                            opcion.opcion5 = this.cargarOpciones(nodo.getChildNodes());
                            break;
                    }
                }
                /*Element e = (Element) nodo;
                NodeList campos = e.getChildNodes();
                for (int j = 0; j < campos.getLength(); j++) {
                    Node hijo = campos.item(j);
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        if (hijo.getNodeName() == "opcion") {
                            int id = Integer.parseInt(hijo.getAttributes().getNamedItem("id").getNodeValue());
                            switch (id) {
                                case 1:
                                    opcion.opcion1 = this.cargarOpciones(hijo.getChildNodes());
                                    break;
                                case 2:
                                    opcion.opcion2 = this.cargarOpciones(hijo.getChildNodes());
                                    break;
                                case 3:
                                    opcion.opcion3 = this.cargarOpciones(hijo.getChildNodes());
                                    break;
                                case 4:
                                    opcion.opcion4 = this.cargarOpciones(hijo.getChildNodes());
                                    break;
                                case 5:
                                    opcion.opcion5 = this.cargarOpciones(hijo.getChildNodes());
                                    break;
                            }
                        }
                    }
                }*/
            }
        }
        return opcion;
    }
}
