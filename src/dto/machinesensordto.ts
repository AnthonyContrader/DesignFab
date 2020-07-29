export class MachineSensorDTO{

    machine_name: String
    idSensor: number
        constructor(machine_name: String, idSensor: number) {
            this.machine_name = machine_name;
            this.idSensor = idSensor;
        }
    
    }