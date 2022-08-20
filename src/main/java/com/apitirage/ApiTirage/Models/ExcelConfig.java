package com.apitirage.ApiTirage.Models;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelConfig {

    public static String excelType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static String SHEET = "Postulants";

    // Methode qui verifi si le fichier est un fichier Excel
    public static Boolean verifier(MultipartFile file) {

        if (excelType.equals(file.getContentType())) {
            return true;
        } else {
            return false;
        }
    }

    // Methode qui retourne la liste des postulants à travers le fichier excel
    // fournit
    public static List<Postulant> postulantsExcel(MultipartFile file) {

        try {
            // creation d'une liste dans la quelle on va mettre la liste recuperée
            List<Postulant> postulants = new ArrayList<Postulant>();

            // lecture du fichier
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Iterator<Sheet> sheet = workbook.sheetIterator();

            DataFormatter formatter = new DataFormatter();

            while (sheet.hasNext()) {

                int numeroLigne = 0;

                // System.out.println(ligne.next().getRowNum());

                Sheet sh = sheet.next();
                Iterator<Row> iterator = sh.iterator();
                // parcour du fichier excel ligne par ligne
                while (iterator.hasNext()) {
                    Row row = iterator.next();
                    Iterator<Cell> cellIterator = row.iterator();
                    // Recuperation de la ligne courante
                    // Row ligneCourante = ligne.next();
                    // on lui dit de sauter la première ligne du fichier, qui est l'entête
                    if (numeroLigne == 0) {
                        numeroLigne++;
                        continue;
                    }

                    // Après avoir recuperer une ligne, on crée un postulant et on recupère ses
                    // attributs;
                    Postulant postulant = new Postulant();

                    int numeroColonne = 0;
                    // parcour des colonnes d'une ligne
                    while (cellIterator.hasNext()) {
                        // Recuperation de la colonne courante
                        Cell colonneCourante = cellIterator.next();
                        // recuperation des infos de chaque colonne
                        switch (numeroColonne) {
                            // première colonne contenant le nom
                            case 0:
                                postulant.setNom(formatter.formatCellValue(colonneCourante));
                                // System.out.println(colonneCourante.getStringCellValue());
                                break;
                            // deuxième colonne contenant le prenom
                            case 1:
                                postulant.setPrenom(formatter.formatCellValue(colonneCourante));
                                break;
                            // troixième colonne contenant le numero
                            case 2:
                                postulant.setNumero(formatter.formatCellValue(colonneCourante));
                                break;
                            // dernière colonne contenant l'adresse mail
                            case 3:
                                postulant.setEmail(formatter.formatCellValue(colonneCourante));
                                break;
                            default:
                                break;
                        }
                        numeroColonne++;
                    }
                    postulants.add(postulant);
                    // numeroLigne++;
                }
            }

            workbook.close();
            return postulants;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            // TODO: handle exception
            return null;
        }

    }


}

   /*public List<Postulant> excelimport(MultipartFile file) {
        String mail="";
        String nom="";
        String prenom="";
        long numero=0;

//    String excelFilePath = "C:\\Users\\kssamake\\Desktop\\Monapi\\apitirage\\listP.xlsx";

        long start = System.currentTimeMillis();//l'heure de debut d'importation

        try {
            // FileInputStream inputStrean = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet firstSheet=workbook.getSheetAt(0);
            Iterator<Row> rowIterator=firstSheet.iterator();
            rowIterator.next();

            while (rowIterator.hasNext()){
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator=nextRow.cellIterator();
                while (cellIterator.hasNext()){
                    Cell nextCell=cellIterator.next();
                    int columnIndex=nextCell.getColumnIndex();
                    switch (columnIndex){
                        case 0:
                            mail=nextCell.getStringCellValue();
                            System.out.println(mail);
                            break;
                        case 1:
                            nom=nextCell.getStringCellValue();
                            System.out.println(nom);
                            break;
                        case 2:
                            prenom=nextCell.getStringCellValue();
                            System.out.println(prenom);
                            break;
                        case 3:
                            numero=(long) nextCell.getNumericCellValue();
                            System.out.println(numero);
                            break;

                    }
                }
                postulantList.add(new Postulant(mail,nom,prenom,numero));
            }
            workbook.close();
            long end = System.currentTimeMillis();//l'heure de fin
            System.out.printf("Import done in %d ms\n", (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  postulantList;
    }

}
 */


