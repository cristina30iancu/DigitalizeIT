import { iEquipment } from "./iequipment";

export interface iPosition {
    id: number;
    name: string;
    first_name: string;
    equipment: iEquipment[];
};