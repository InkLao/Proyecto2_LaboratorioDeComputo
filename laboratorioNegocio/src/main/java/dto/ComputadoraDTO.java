package dto;

/**
 * Clase de transferencia de datos (DTO) para representar la información de una computadora.
 * Esta clase se utiliza para transferir datos entre la capa de negocio y la capa de presentación, 
 * encapsulando la información de la computadora sin exponer la entidad directamente.
 * 
 * @autor Arturo ITSON
 */
public class ComputadoraDTO {

    /**
     * Identificador único de la computadora.
     */
    private long id;

    /**
     * Dirección IP de la computadora.
     */
    private String ip;

    /**
     * Estado actual de la computadora (ej. disponible, en uso, etc.).
     */
    private String estatus;

    /**
     * Número de máquina asignado a la computadora.
     */
    private Integer numeroMaquina;

    /**
     * Indica si la computadora es de uso exclusivo para alumnos.
     */
    private boolean usoAlumno;

    /**
     * Identificador del centro o laboratorio al que pertenece la computadora.
     */
    private long centroLaboratorio;

    /**
     * Indica si la computadora está marcada como eliminada.
     */
    private boolean eliminado;

    /**
     * Constructor por defecto de la clase ComputadoraDTO.
     */
    public ComputadoraDTO() {
    }

    /**
     * Constructor completo de la clase ComputadoraDTO.
     * 
     * @param id Identificador único de la computadora.
     * @param ip Dirección IP de la computadora.
     * @param estatus Estado actual de la computadora.
     * @param numeroMaquina Número de máquina de la computadora.
     * @param usoAlumno Indica si es de uso exclusivo para alumnos.
     * @param centroLaboratorio Identificador del centro al que pertenece.
     * @param eliminado Estado de eliminación de la computadora.
     */
    public ComputadoraDTO(long id, String ip, String estatus, Integer numeroMaquina, boolean usoAlumno, long centroLaboratorio, boolean eliminado) {
        this.id = id;
        this.ip = ip;
        this.estatus = estatus;
        this.numeroMaquina = numeroMaquina;
        this.usoAlumno = usoAlumno;
        this.centroLaboratorio = centroLaboratorio;
        this.eliminado = eliminado;
    }

    /**
     * Constructor de la clase ComputadoraDTO sin el campo id.
     * 
     * @param ip Dirección IP de la computadora.
     * @param estatus Estado actual de la computadora.
     * @param numeroMaquina Número de máquina de la computadora.
     * @param usoAlumno Indica si es de uso exclusivo para alumnos.
     * @param centroLaboratorio Identificador del centro al que pertenece.
     * @param eliminado Estado de eliminación de la computadora.
     */
    public ComputadoraDTO(String ip, String estatus, Integer numeroMaquina, boolean usoAlumno, long centroLaboratorio, boolean eliminado) {
        this.ip = ip;
        this.estatus = estatus;
        this.numeroMaquina = numeroMaquina;
        this.usoAlumno = usoAlumno;
        this.centroLaboratorio = centroLaboratorio;
        this.eliminado = eliminado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Integer getNumeroMaquina() {
        return numeroMaquina;
    }

    public void setNumeroMaquina(Integer numeroMaquina) {
        this.numeroMaquina = numeroMaquina;
    }

    public boolean isUsoAlumno() {
        return usoAlumno;
    }

    public void setUsoAlumno(boolean usoAlumno) {
        this.usoAlumno = usoAlumno;
    }

    public long getCentroLaboratorio() {
        return centroLaboratorio;
    }

    public void setCentroLaboratorio(long centroLaboratorio) {
        this.centroLaboratorio = centroLaboratorio;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Representación en formato de texto de los datos de la computadora.
     *
     * @return Una cadena de texto con los datos de la computadora.
     */
    @Override
    public String toString() {
        return "ComputadoraDTO{" + "id=" + id + ", ip=" + ip + ", estatus=" + estatus + ", numeroMaquina=" + numeroMaquina + ", usoAlumno=" + usoAlumno + ", centroLaboratorio=" + centroLaboratorio + ", eliminado=" + eliminado + '}';
    }
}
