/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author yosgs
 */
public class GuardarArchivo {

    public static String ruta = "/Users/yosgs/Documents/testArchivos/";

    public static boolean guardarCapitulos(MultipartFile[] files, String[] titulo, String[] numero, String parametrosLibro) {
        String rutaLibro = Rutas.rutaArchivos + parametrosLibro;// "/Users/yosgs/Documents/testArchivos/ + usuario/nombreLibro/+    NombreCapitulo.pdf
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            Path path = Paths.get(rutaLibro + "Cap" + numero[i] + "_" + titulo[i] + ".pdf");
            try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
                Files.write(path, files[i].getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static boolean guardarPortada(MultipartFile file, String rutaComplemento) {
        String tipo = ((file.getContentType().toString()).split("/"))[1];
        Path path = Paths.get(Rutas.rutaArchivos + rutaComplemento + "/Portada" + "." + tipo);
        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
            Files.write(path, file.getBytes());
            System.out.println("Archivo guardado correctamente");
            return true;
        } catch (IOException ex) {
            System.err.println("No se pudo agregar el archivo");
            ex.printStackTrace();
            return false;
        }

    }

    public static boolean crearCarpeta(String parametros) {
        String pathArchivo;
        if (parametros.isEmpty()) {
            pathArchivo = Rutas.rutaArchivos;
        } else {
            pathArchivo = Rutas.rutaArchivos + parametros;
        }
        Path path = Paths.get(pathArchivo);
        System.out.println("RUTA = " + pathArchivo);
        if (Files.exists(path)) {
            System.out.println("EXISTE");
            return true;
        } else {
            try {
                Files.createDirectories(path);
                System.out.println("DIRECTORIO CREADO " + pathArchivo);
                return true;
            } catch (IOException ex) {
                Logger.getLogger(GuardarArchivo.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("ERROR AL CREAR EL DIRECTORIO " + pathArchivo);
                return false;
            }
        }
    }

    public static byte[] leerImagenes(String rutaImg) {
        Path filePath = Paths.get(Rutas.rutaArchivos + rutaImg);
        byte[] bytes=null;
        if (Files.exists(filePath)) {
            try {
                bytes = Base64.getEncoder().encode(Files.readAllBytes(filePath));
            } catch (IOException e) {
                bytes = null;
            }
        }
        return bytes;
    }

}
