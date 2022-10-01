import { iPosition } from "./iposition";

export interface iNewJoiner {
    id: number;
    last_name: string;
    first_name: string;
    position: iPosition;
    startDate: Date;
    project: string;
    done: boolean;
};