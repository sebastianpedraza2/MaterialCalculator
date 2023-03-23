# MaterialCalculator
App developed using a production ready merging strategy hooked up with CI/CD pipelines to automate the decision of integrating one branch into another upon the creation of Pull requests (this repository also contains an advanced PR template to help contributors).

Bitrise was used to integrate CI/CD pipelines 

## MERGING STRATEGY USED: 
MASTER, STAGING, DEVELOPMENT

## PIPELINES IMPLEMENTED:
* **CI WORKFLOW:** Used to integrate changes to the development branch.
* **CD  STAGING WORKFLOW:** Used to send a pre-release APK to testers using Firebase Distribution.
* **CD PRODUCTION WORKFLOW:** Used to update a production ready APK and send it to the userbase in Google play.
## Screenshots

<img width="333" alt="image" src="https://user-images.githubusercontent.com/46971682/227280278-a9a2e6c6-2637-4fbb-b5dd-2032e1bbcc60.png">
<img width="345" alt="image" src="https://user-images.githubusercontent.com/46971682/227281818-8fe6eb8e-3dac-4b80-976f-5d1017f1d047.png">
