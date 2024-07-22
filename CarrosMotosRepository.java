import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class CarrosMotosRepository
{
    private static Database database;
    private static Dao<CarrosMotos, Integer> dao;
    private List<CarrosMotos> loadedCarrosMotos;
    private CarrosMotos loadedCarrosMoto; 
    
    public CarrosMotosRepository(Database database) {
        CarrosMotosRepository.setDatabase(database);
        loadedCarrosMotos = new ArrayList<CarrosMotos>();
    }
    
    public static void setDatabase(Database database) {
        CarrosMotosRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), CarrosMotos.class);
            TableUtils.createTableIfNotExists(database.getConnection(), CarrosMotos.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public CarrosMotos create(CarrosMotos carrosMoto) {
        int nrows = 0;
        try {
            nrows = dao.create(carrosMoto);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedCarrosMoto = carrosMoto;
            loadedCarrosMotos.add(carrosMoto);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return carrosMoto;
    }    

    public void update(CarrosMotos carrosMoto) {
        try {
            int nrows = dao.update(carrosMoto);
            if (nrows == 0) {
                throw new SQLException("Error: object not updated");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(CarrosMotos carrosMoto) {
        try {
            int nrows = dao.delete(carrosMoto);
            if (nrows == 0) {
                throw new SQLException("Error: object not deleted");
            }
            loadedCarrosMotos.remove(carrosMoto);
            if (carrosMoto.equals(loadedCarrosMoto)) {
                loadedCarrosMoto = null;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public CarrosMotos loadFromId(int id) {
        try {
            this.loadedCarrosMoto = dao.queryForId(id);
            if (this.loadedCarrosMoto != null)
                this.loadedCarrosMotos.add(this.loadedCarrosMoto);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedCarrosMoto;
    }    
    
    public List<CarrosMotos> loadAll() {
        try {
            this.loadedCarrosMotos =  dao.queryForAll();
            if (this.loadedCarrosMotos.size() != 0)
                this.loadedCarrosMoto = this.loadedCarrosMotos.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedCarrosMotos;
    }

    // getters and setters omitted...        
}
