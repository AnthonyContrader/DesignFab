export class SensormaterialDTO{

sensor_name: String
idMaterial: number
idSensor: number
    constructor(sensor_name: String, idMaterial: number, idSensor?: number) {
        this.sensor_name = sensor_name;
        this.idMaterial = idMaterial;
        this.idSensor = idSensor;
    }


}