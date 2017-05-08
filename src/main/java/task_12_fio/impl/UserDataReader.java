package task_12_fio.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UserDataReader {
    private String path;


    public UserDataReader(String path) {
        this.path = path;
    }


    public ArrayList<UserVO> readUsers() {
        ArrayList<UserVO> users = new ArrayList<>();

        Document document = this.openDocument();
        if (document == null) {
            System.out.println("Cannot parse document!!!");
            return users;
        }


        Element e = document.getDocumentElement();
        NodeList nodeList = e.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); ++i) {
            Node tempNode = nodeList.item(i);
            if (tempNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            UserVO userVO = this.parseUserNode(tempNode);
            assert userVO != null;

            users.add(userVO);
        }
        return users;
    }


    private UserVO parseUserNode(Node userNode) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(UserVO.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (UserVO) jaxbUnmarshaller.unmarshal(userNode);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


    private Document openDocument() {
        try {
            File file = new File(path);

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();

            return document;
        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
        } catch (SAXException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return null;
    }
}
