import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName = "carros_motos")
public class CarrosMotos {   
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField(dataType = DataType.DATE)
    private Date anodefabricacao;
    
    @DatabaseField
    private int capacidademaximapassageiros;
    
    @DatabaseField
    private String cor;
    
    @DatabaseField
    private String modelo;
    
    @DatabaseField
    private String documento;
    
    @DatabaseField
    private String carroOuMoto;
    
    // Método para determinar se é carro ou moto
    public void definirCarroOuMoto(String tipo) {
        if ("c".equalsIgnoreCase(tipo)) {
            this.carroOuMoto = "Carro";
        } else if ("m".equalsIgnoreCase(tipo)) {
            this.carroOuMoto = "Moto";
        } else {
            throw new IllegalArgumentException("Tipo inválido: Use 'c' para Carro ou 'm' para Moto.");
        }
    }

    // Start GetterSetterExtension Source Code

    /**GET Method Propertie id*/
    public int getId(){
        return this.id;
    }//end method getId

    /**SET Method Propertie id*/
    public void setId(int id){
        this.id = id;
    }//end method setId

    /**GET Method Propertie anodefabricacao*/
    public Date getAnoDeFabricacao(){
        return this.anodefabricacao;
    }//end method getAnoDeFabricacao

    /**SET Method Propertie anodefabricacao*/
    public void setAnoDeFabricacao(Date anodefabricacao){
        this.anodefabricacao = anodefabricacao;
    }//end method setAnoDeFabricacao

    /**SET Method Propertie anodefabricacao usando GregorianCalendar*/
    public void setAnoDeFabricacao(int year, int month, int dayOfMonth) {
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, dayOfMonth);
        this.anodefabricacao = calendar.getTime();
    }
    
    /**GET Year of AnoDeFabricacao*/
    public int getAnoDeFabricacaoAno() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.anodefabricacao);
        return calendar.get(Calendar.YEAR);
    }

    /**GET Method Propertie capacidademaximapassageiros*/
    public int getCapacidadeMaximaPassageiros(){
        return this.capacidademaximapassageiros;
    }//end method getCapacidadeMaximaPassageiros

    /**SET Method Propertie capacidademaximapassageiros*/
    public void setCapacidadeMaximaPassageiros(int capacidademaximapassageiros){
        this.capacidademaximapassageiros = capacidademaximapassageiros;
    }//end method setCapacidadeMaximaPassageiros

    /**GET Method Propertie cor*/
    public String getCor(){
        return this.cor;
    }//end method getCor

    /**SET Method Propertie cor*/
    public void setCor(String cor){
        this.cor = cor;
    }//end method setCor

    /**GET Method Propertie modelo*/
    public String getModelo(){
        return this.modelo;
    }//end method getModelo

    /**SET Method Propertie modelo*/
    public void setModelo(String modelo){
        this.modelo = modelo;
    }//end method setModelo

    /**GET Method Propertie documento*/
    public String getDocumento(){
        return this.documento;
    }//end method getDocumento

    /**SET Method Propertie documento*/
    public void setDocumento(String documento){
        this.documento = documento;
    }//end method setDocumento

    /**GET Method Propertie carroOuMoto*/
    public String getCarroOuMoto(){
        return this.carroOuMoto;
    }//end method getCarroOuMoto

    /**SET Method Propertie carroOuMoto*/
    public void setCarroOuMoto(String carroOuMoto){
        this.carroOuMoto = carroOuMoto;
    }//end method setCarroOuMoto

    // End GetterSetterExtension Source Code
}
