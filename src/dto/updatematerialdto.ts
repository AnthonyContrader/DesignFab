import { Materialtype } from './Materialtype';

export class UpdateMaterialDTO {

    materialType : Materialtype;

    constructor(materyalType : Materialtype) {
        this.materialType = materyalType;
    }
}