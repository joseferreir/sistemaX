/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.controle;

/**
 *
 * @author Aluisio
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author José
 */
public class ProcessadorFotos {

    private String folder;

    public ProcessadorFotos(String folder) {
        this.folder = folder;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public boolean salvarImagem(String path, FileItemStream item, String nameToSave) {
        try {
            File f = new File(path);
//            File f = new File(path+File.separator+folder);            
//            File parent = new File(f.getParent());
//            
//            if(!parent.exists())
//                parent.mkdir();
            if (!f.exists()) {
                f.mkdir();
            }

            File savedFile = new File(f.getAbsoluteFile() + File.separator + nameToSave);
            FileOutputStream fos = new FileOutputStream(savedFile);

            InputStream is = item.openStream();

            int x = 0;
            byte[] b = new byte[1024];
            while ((x = is.read(b)) != -1) {
                fos.write(b, 0, x);
            }
            fos.flush();
            fos.close();

            return true;

        } catch (Exception ex) {
        }
        return false;
    }

    public String processarArquivo(HttpServletRequest request, String nameToSave)
            throws ServletException, IOException, FileUploadException {

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            ServletFileUpload upload = new ServletFileUpload();
            try {
                FileItemIterator itr = upload.getItemIterator(request);

                while (itr.hasNext()) {
                    FileItemStream item = itr.next();
                    if (!item.isFormField()) {
//                        pode ser tb sem a barra ????
//                        String path = request.getServletContext().getRealPath("");
                        String contextPath = request.getServletContext().getRealPath("/");
//                        String nameToSave = "profileImage" + Calendar.getInstance().getTimeInMillis() + item.getName();
//                        String nameToSave = "imagemPerfil" + item.getName();
                        if (salvarImagem(contextPath + File.separator + folder, item, nameToSave)) {
                            return folder + "/" + nameToSave;
                        }
                    }
                }

            } catch (FileUploadException ex) {
                System.out.println("erro ao obter informaçoes sobre o arquivo");
            }

        } else {
            System.out.println("Erro no formulario!");
        }

        return null;
    }

}
