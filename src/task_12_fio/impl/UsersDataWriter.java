package task_12_fio.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;

public class UsersDataWriter {
    private HashMap<String, UserVO> users;


    public UsersDataWriter(HashMap<String, UserVO> users) {
        this.users = users;
    }


    public void write() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.newDocument();

            Element root = doc.createElement("users");
            doc.appendChild(root);

            for (UserVO userVO : users.values()) {
                root.appendChild(createUserElement(doc, userVO));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(Consts.getUsersFilePath()));
            transformer.transform(source, result);

            // System.out.println("Done!");

        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }


    private Element createUserElement(Document doc, UserVO userVO) {
        Element userElement = doc.createElement("userVO");
        userElement.setAttribute("id", String.valueOf(userVO.getId()));

        userElement.appendChild(createElement(doc, "fullname", userVO.getFullname()));
        userElement.appendChild(createElement(doc, "birthdate", userVO.getBirthdate()));
        userElement.appendChild(createElement(doc, "address", userVO.getAddress()));
        userElement.appendChild(createElement(doc, "tel", userVO.getTel()));

        return userElement;
    }


    private Element createElement(Document doc, String tagName, String value) {
        Element result = doc.createElement(tagName);
        result.appendChild(doc.createTextNode(value));
        return result;
    }
}
