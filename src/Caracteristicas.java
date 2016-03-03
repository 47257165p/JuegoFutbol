/**
 * Created by 47257165p on 26/02/16.
 */
public class Caracteristicas {

    private byte agilidad;
    private byte fuerza;
    private byte velocidad;
    private byte resistencia;
    private byte tiro;

    public Caracteristicas(byte agilidad, byte fuerza, byte velocidad, byte resistencia, byte tiro) {
        this.agilidad = agilidad;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.resistencia = resistencia;
        this.tiro = tiro;
    }

    public Caracteristicas(){
    }

    public byte getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(byte agilidad) {
        this.agilidad = agilidad;
    }

    public byte getFuerza() {
        return fuerza;
    }

    public void setFuerza(byte fuerza) {
        this.fuerza = fuerza;
    }

    public byte getResistencia() {
        return resistencia;
    }

    public void setResistencia(byte resistencia) {
        this.resistencia = resistencia;
    }

    public byte getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(byte velocidad) {
        this.velocidad = velocidad;
    }

    public byte getTiro() {
        return tiro;
    }

    public void setTiro(byte tiro) {
        this.tiro = tiro;
    }

    public void modificarCaracteristicas(byte agilidad, byte fuerza, byte velocidad, byte resistencia, byte tiro)
    {
        this.agilidad=agilidad;
        this.fuerza=fuerza;
        this.velocidad=velocidad;
        this.resistencia=resistencia;
        this.tiro=tiro;
    }

    public String toString()
    {
        return "Agilidad = "+agilidad+" - Fuerza = "+fuerza+" - Velocidad = "+velocidad+" - Resistencia = "+resistencia+" - Tiro = "+tiro;
    }
}
