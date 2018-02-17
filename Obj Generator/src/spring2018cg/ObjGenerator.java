/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring2018cg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author monirulhasan
 */
public class ObjGenerator {

    public static void main(String[] args) {
        String filename = "models.txt";
        
        try (RandomAccessFile input = new RandomAccessFile(filename, "r")) {
            String line;
            
            while ((line = input.readLine()) != null) {
                if (line.startsWith("cube")) {
                    String tokens[] = line.split("\\ "); // regex
                    int length = Integer.parseInt(tokens[1]);
                    generateCube(length);
                } else if (line.startsWith("sphere")) {
                    // add your own code
                } else {
                    // add your own code for cyllinder and helix
                }
            }
            
            input.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ObjGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void generateCube(int length) {
        try (RandomAccessFile output = new RandomAccessFile("output.obj", "rw")) {
            output.setLength(0);
            output.writeBytes("o Cube\n");
            double halfLength = length / 2.0;
            output.writeBytes(String.format("v %.3f %.3f %.3f\n", halfLength, -halfLength, halfLength));
            output.writeBytes(String.format("v %.3f %.3f %.3f\n", halfLength, -halfLength, -halfLength));
            output.writeBytes(String.format("v %.3f %.3f %.3f\n", -halfLength, -halfLength, -halfLength));
            output.writeBytes(String.format("v %.3f %.3f %.3f\n", -halfLength, -halfLength, halfLength));
            output.writeBytes(String.format("v %.3f %.3f %.3f\n", halfLength, halfLength, halfLength));
            output.writeBytes(String.format("v %.3f %.3f %.3f\n", halfLength, halfLength, -halfLength));
            output.writeBytes(String.format("v %.3f %.3f %.3f\n", -halfLength, halfLength, -halfLength));
            output.writeBytes(String.format("v %.3f %.3f %.3f\n", -halfLength, halfLength, halfLength));

            output.writeBytes(String.format("f %d %d %d %d\n", 1, 2, 3, 4));
            output.writeBytes(String.format("f %d %d %d %d\n", 5, 6, 7, 8));
            output.writeBytes(String.format("f %d %d %d %d\n", 1, 2, 6, 5));
            output.writeBytes(String.format("f %d %d %d %d\n", 2, 3, 7, 6));
            // add the other two faces by yourself
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ObjGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
