package kiemTraTK2;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XuLyXML {
	private static String fileName = "sinhvien.xml";
	private DocumentBuilderFactory factory;
	private DocumentBuilder documentBuilder;
	private Document document;
	
	public XuLyXML() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			documentBuilder = factory.newDocumentBuilder();
			document = documentBuilder.parse(fileName);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public ArrayList<SinhVien> getAllProducts(){
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		Element root = document.getDocumentElement();
		NodeList plist =  root.getElementsByTagName("sinhvien");
		int cout = plist.getLength();
		for (int i = 0; i < cout; i++) {
			Element pNode = (Element) plist.item(i);
			String id = pNode.getAttribute("id");
			String hoten = pNode.getElementsByTagName("hoten").item(0).getTextContent();
			String lop = pNode.getElementsByTagName("lop").item(0).getTextContent();
			String noisinh = pNode.getElementsByTagName("noisinh").item(0).getTextContent();
			String monhoc = pNode.getElementsByTagName("monhoc").item(0).getTextContent();

			SinhVien sv = new SinhVien(id, hoten, lop, noisinh, monhoc);
			list.add(sv);
		}	
		return list;
	}
	public void writeXML() {
		TransformerFactory factory;
		Transformer transformer;
		try {
			factory = TransformerFactory.newInstance();
			transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(fileName));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void add(SinhVien sv) {
		Element root = document.getDocumentElement();
		Element pnode = document.createElement("sinhvien");
		root.appendChild(pnode);
		pnode.setAttribute("id",sv.getId());
		
		Node nameNode0 = document.createElement("hoten");
		pnode.appendChild(nameNode0);
		nameNode0.setTextContent(sv.getHoten());
		Node nameNode1 = document.createElement("lop");
		pnode.appendChild(nameNode1);
		nameNode1.setTextContent(sv.getLop());
		Node nameNode2 = document.createElement("noisinh");
		pnode.appendChild(nameNode2);
		nameNode2.setTextContent(sv.getNoisinh());
		Node nameNode3 = document.createElement("monhoc");
		pnode.appendChild(nameNode3);
		nameNode3.setTextContent(sv.getMonhoc());
	
	}
	public void delete(String pid) {
		Element root = document.getDocumentElement();
		NodeList list = root.getElementsByTagName("sinhvien");
		for (int i = 0; i < list.getLength(); i++) {
			Element pNode = (Element) list.item(i);
			String id = pNode.getAttribute("id");
			if (id.equalsIgnoreCase(pid)) {
				pNode.getParentNode().removeChild(pNode);
				break;
			}
		}
	}
	public void update(String pid,String tenlop) {
		Element root = document.getDocumentElement();
		NodeList list = root.getElementsByTagName("sinhvien");
		for (int i = 0; i < list.getLength(); i++) {
			Element pNode = (Element) list.item(i);
			String id = pNode.getAttribute("id");
			if (id.equalsIgnoreCase(pid)) {
				Node lopmoi = pNode.getElementsByTagName("lop").item(0);
				lopmoi.setTextContent(tenlop+"");
				break;
			}
		}
	}
	public ArrayList<SinhVien> searchSinhVien(String tenLop) {
	    ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	    Element root = document.getDocumentElement();
	    NodeList plist = root.getElementsByTagName("sinhvien");
	    for (int i = 0; i < plist.getLength(); i++) {
	      Element pNode = (Element) plist.item(i);
	      String lop = pNode.getElementsByTagName("lop").item(0).getTextContent();
	      if (lop.equals(tenLop)) {
	        String mssv = pNode.getAttribute("id");
	        String hoTen = pNode.getElementsByTagName("hoten").item(0).getTextContent();
	        String noiSinh = pNode.getElementsByTagName("noisinh").item(0).getTextContent();
	        String monHoc = pNode.getElementsByTagName("monhoc").item(0).getTextContent();
	        dsSinhVien.add(new SinhVien(mssv, hoTen, lop, noiSinh, monHoc));
	      }
	    }
	    return dsSinhVien;
	  }
	
	}

