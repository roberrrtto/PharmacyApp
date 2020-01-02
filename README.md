# Pharmacy

System that allows to run a small pharmacy chain.

## Business needs
- 3 levels of access (admin, unit manager, pharmacist)
- Pharmacist: 
    - sale mode
- Unit Manager:
    - list of all team members (+ check the details option)
    - updates on a quantity of medicines in storage
    - receipt quick-preview
    - sales check
- Admin:
    - CRUD for all entities
    
## Tech Stack
- Java 8
- Maven
- ElephantSQL
- PostgreSQL
- pgAdmin 4
- GUI: Swing
- IDE: Intellij Ultimate
- GitHub

## Project Structure

![projectStructure](src/main/resources/readMeImg/projectStructure.png)
#
![pharmacyPackageDiagram](src/main/resources/readMeImg/pharmacyPackageDiagram.png)

## A little sneak peek at GUI
### Login Panel
![InitialPanel](src/main/resources/readMeImg/login.png)

### PharmacistPanel (Sale Mode)
![Pharmacist](src/main/resources/readMeImg/Pharmacist.png)

### ManagerPanel
![ManagerPanel](src/main/resources/readMeImg/ManagerPanel.png)

### AdminMenu
![AdminMenu](src/main/resources/readMeImg/AdminMenu.png)

### AdminPharmacy
![AdminPharmacy](src/main/resources/readMeImg/AdminPharmacy.png)

### AdminUpdateUser
![AdminUpdateUser](src/main/resources/readMeImg/AdminUpdateUser.png)

### AdminShowUsers
![AdminShowUsers](src/main/resources/readMeImg/AdminShowUsers.png)
