export class MachineSensorDTO{

    machine_name: String
    idSensor: number
    idMachine: number
        constructor(machine_name: String, idSensor: number, idMachine?: number) {
            this.machine_name = machine_name;
            this.idSensor = idSensor;
            this.idMachine = idMachine;
        }
    
    }