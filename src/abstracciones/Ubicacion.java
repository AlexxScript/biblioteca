/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstracciones;

/**
 *
 * @author alexamn
 */
public class Ubicacion {
    private String id;
    private String pasillo;
    private String repisa;
    private String anaquel;
    private String seccion;

    public Ubicacion(String id, String pasillo, String repisa, String anaquel, String seccion) {
        this.id = id;
        this.pasillo = pasillo;
        this.repisa = repisa;
        this.anaquel = anaquel;
        this.seccion = seccion;
    }

    public static class UbicacionBuilder implements IBuilder<Ubicacion>{
        private String id;
        private String pasillo;
        private String repisa;
        private String anaquel;
        private String seccion;

        public UbicacionBuilder(String id, String pasillo, String repisa, String anaquel, String seccion) {
            this.id = id;
            this.pasillo = pasillo;
            this.repisa = repisa;
            this.anaquel = anaquel;
            this.seccion = seccion;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPasillo() {
            return pasillo;
        }

        public void setPasillo(String pasillo) {
            this.pasillo = pasillo;
        }

        public String getRepisa() {
            return repisa;
        }

        public void setRepisa(String repisa) {
            this.repisa = repisa;
        }

        public String getAnaquel() {
            return anaquel;
        }

        public void setAnaquel(String anaquel) {
            this.anaquel = anaquel;
        }

        public String getSeccion() {
            return seccion;
        }

        public void setSeccion(String seccion) {
            this.seccion = seccion;
        }
        
        @Override
        public Ubicacion build(){
            return new Ubicacion(id, pasillo, repisa, anaquel, seccion);
        }
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasillo() {
        return pasillo;
    }

    public void setPasillo(String pasillo) {
        this.pasillo = pasillo;
    }

    public String getRepisa() {
        return repisa;
    }

    public void setRepisa(String repisa) {
        this.repisa = repisa;
    }

    public String getAnaquel() {
        return anaquel;
    }

    public void setAnaquel(String anaquel) {
        this.anaquel = anaquel;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
}
