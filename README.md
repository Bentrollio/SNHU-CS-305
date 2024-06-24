# SNHU-CS-305
Software Security

## Briefly summarize your client, Artemis Financial, and its software requirements. Who was the client? What issue did the company want you to address?

Artemis Financial is a corporation that seeks to implement a secure financial services application for its clients. Secure communications are invaluable to Artemis Financial because it is entrusted with confidential financial details for its customers, who are an enticing target for cyber attackers. Like any financial institution, its communications contain account information such as account numbers, balances, and transaction details that can be used to zero in on individual account holders and expose them to fraud and identity theft. The software also must comply with domestic and international regulations such as the Gramm-Leach-Billey Act (GLBA) or European General Data Protection Regulation.

## What did you do well when you found your client’s software security vulnerabilities? Why is it important to code securely? What value does software security add to a company’s overall well-being?

I did well at researching the vulnerabilities and getting a general idea of what the description in the National Vulnerability Database meant. It's important to code securely because it is time-consuming and expensive to patch and change code after release. Secure coding is beneficial to company health because it saves money and maintains consumer confidence.

## Which part of the vulnerability assessment was challenging or helpful to you?

The most challenging part was the manual code review. Up to this point, we were coding to achieve required functionality. So long as the code served its purpose, it was good. In this class, however, it's important to additionally analyze code from an adversaries perspective.

## How did you increase layers of security? In the future, what would you use to assess vulnerabilities and decide which mitigation techniques to use?

I started from the micro-level by analyzing individual bits of code to ensure that my foundation was secure before delving into upgrading software libraries. OWASP Dependency-Check and the book Iron Clad Java were helpful in finding libraries to upgrade, and general best practices in coding, respectively.

## How did you make certain the code and software application were functional and secure? After refactoring the code, how did you check to see whether you introduced new vulnerabilities?

I utilized functional programming to break each code block's functionality down. This helped because once I completed a function, I reviewed the code (especially the bytesToHex function because it used string operations), and would attempt to research if I coded something insecurely. Snyk and its code review process was invaluable. Finally, after updating all of my libraries, if I introduced a new library I would run Dependency-Check once more to ensure that any newly introduced CVDs can be taken care of.

## What resources, tools, or coding practices did you use that might be helpful in future assignments or tasks?

Learning about the Open Worldwide Application Security Project (OWASP) was invaluable. I enjoyed their cheat sheets because it was easy to navigate and explained cybersecurity concepts well. The Dependency-Check tool was invaluable at teaching me the importance of updating software through its CVD list. Seeing the number of vulnerabilities dwindle as I updated dependencies was satisfying.

## Employers sometimes ask for examples of work that you have successfully completed to show your skills, knowledge, and experience. What might you show future employers from this assignment?

I am especially proud of my "Vulnerability Assessment Report" because it shows a potential employer my skill at breaking problems down and presenting strongly sourced solutions palpably. However, I think the "Practices for Secure Software Report" showcases a little bit of my creativity. If I had more time, I would have liked to implemented better parameterized inputs and a user authentication scheme with different pages for different access levels.