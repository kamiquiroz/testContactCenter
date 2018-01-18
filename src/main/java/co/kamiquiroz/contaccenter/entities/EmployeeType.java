package co.kamiquiroz.contaccenter.entities;



public enum EmployeeType
{
    OPERATOR(1), SUPERVISOR(2),DIRECTOR(3);

    private int priority; // Variable interna que definira la prioridad del tipo de empleado

    // Constructor fuerza a pasar parámetros al definir un nuevo tipo
    EmployeeType(int priority) {
        this.priority = priority;
    }
    //Devuelve la prioridad del tipo de empleado
    public int getPriority() {
        return priority;
    }
}


