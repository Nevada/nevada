import org.springframework.beans.factory.annotation.Configurable;

privileged aspect Department_Roo_Configurable {
    
    declare @type: Department: @Configurable;
    
}
