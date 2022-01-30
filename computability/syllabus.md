# Computability

MAT 4520

4 credits  
Spring 2022

**Instructor**: Professor Abdul-Quader (or just "Athar")  
**Email**: athar.abdulquader AT purchase DOT edu  
**Office Hours** TBD in Natural Sciences 3003 / possibly on Zoom?  
**Meeting Times**: Mondays and Thursdays, 4:30 - 6:10  
**Location**: Natural Sciences 2001

## Course Description

**Prerequisite**: Computer Science II  
An introduction to concepts and methods of theoretical computer science: what it means for something to be computable (finite state automata, formal languages, Turing machines) and how to measure resources used to solve problems (Big Oh notation and complexity classes like P and NP). Some attention is paid to the relationship between computability, logic, and philosophy, as well as "impossibility" results in these disciplines. This course brings together the two parts of the major in mathematics/computer science and provides historical background as well as insight into current issues.

## Learning Outcomes

Upon completion of this course, students should be able to...

* Understand some of the basic structures of mathematics, including sets (and operations on sets), functions, and relations. (PLO 5)
* Determine the languages described by various constructs, including finite state machines, context free grammars, and Turing Machines. (PLO 1)
* Create a finite state automata, context free grammar, or Turing Machine for a given language. (PLO 1, 2)
* Understand non-determinism, including the equivalence between deterministic and non-deterministic models in various contexts. (PLO 1, 3, 5)
* Explain what it means for a problem to be unsolvable by an algorithm, and to give examples of such problems. (PLO 3)
* Classify problems as being either decidable (solvable by an algorithm) or undecidable. (PLO 3, 5)
* Compare the relative degrees of unsolvability between problems. (PLO 3, 5)
* Explain what is meant by the running time of an algorithm.  (PLO 3)
* Define the different complexity classes, including P and NP, in a variety of ways, and explain why these definitions are equivalent. (PLO 4)
* Apply various proof techniques, including induction, contradiction, and direct proof, to analyze and construct arguments regarding automata, grammars, Turing Machines, and complexity theory. (PLO 3, 5)

## Textbook

We will be following the classic textbook by Sipser: *Introduction to the Theory of Computation* (3rd edition) by Michael Sipser. ISBN-13: 978-1133187790   
Available at Amazon, the bookstore, etc.  

The book is strongly recommended, but not required. Feel free to purchase the second edition / used copies if they are cheaper. We will also use readings from [Maheshwari and Smid, *Introduction to the Theory of Computation (draft)](https://cglab.ca/~michiel/TheoryOfComputation/TheoryOfComputation.pdf).

## Discord Server

Over the past year, some students have found that using a Discord server to chat remotely about coursework was very helpful. I encourage you all to join our Discord server for this course. I will monitor the chat from time to time to help answer questions, but you all should join so you can work with each other!

The link to the Discord server will be available on Moodle.

## Attendance

My expectation is that students come to class as much as possible. Given the ongoing nature of the pandemic, I understand when this may be difficult or outright impossible (see the next section on community health). In particular, please do stay home if you feel sick at all. I will do my best to make sure notes, readings, and other materials are available online for those who need them.

That said, please do come to class as much as you can. This will allow me to see how well students understand material, and you to work through problems and questions with each other (and me).

## Community Health During COVID-19

To ensure that each of us has a healthy and safe learning experience, all students are required to remain informed and follow Purchase College Policy and/or any departmental, local, state, or federal laws, rules, or regulations for attending classes on campus and in a remote learning environment.

Within courses that involve in-person contact, all students, faculty members, staff, and visitors are required to adhere to the expectations outlined on the [College’s COVID-19 website](https://www.purchase.edu/covid-19-updates-and-plans/). Failure to comply with requirements (e.g. wearing masks, maintaining social distancing where applicable) will result in the request to leave the classroom for that in-person class session. Students may also be referred to the [Office of Community Standards](https://www.purchase.edu/offices/community-standards/).

Do not enter campus buildings if you test positive for or are experiencing any symptoms of COVID-19. Contact your faculty and [Health Services](https://www.purchase.edu/offices/health-services/index.php) if you need to miss class because of COVID-19 symptoms or a positive COVID-19 test result. The conservatory/school will address on a case by case basis student absences due to COVID-19, while awaiting test results, or during quarantine.

## Grading Policy

* 10% Pre-class work and participation (watching videos, short responses)
* 30% Quizzes and/or take-home exams
* 40% Problem Sets (5-8 problem sets)
* 10%: VoiceThread Presentations (2 proof / problem presentations)
* 10%: Final paper and presentation

## Late Homework Policy

Being absent the day that homework is assigned, or the day that it is due, is **not** an excuse for being late with your homework. If you miss a class, you are expected to email any work that is due that day. I reserve the right to not accept homework assignments late, or to penalize such submissions. In the past, I have given a 50% penalty for late homework assignments.

## Collaboration Policy

You are encouraged to *discuss* homework assignments and problem sets with other students. You must complete the assignment on your own, however. There is a clear difference between copying someone else’s work and discussing a problem with another person. The latter is encouraged. Plagiarising another student’s work can lead to academic sanctions as per [Purchase College’s Academic Integrity Policy](https://www.purchase.edu/live/blurbs/840-academic-and-professional-integrity)

Collaboration is not allowed on any exam, including take-home exams. We will have time in-class for questions about take-home exams.

## Office of Disabilities

It is my goal that this class be an accessible and welcoming experience for all students, including those with disabilities. You are welcome to talk to me at any point in the semester about course design concerns, but it is always best if we can talk as soon as possible about the need for any modifications. The Office of Disability Resources collaborates directly with students who identify documented disabilities to create accommodation plans, including testing accommodations, in order for students to access course content and validly demonstrate learning. For those students who may require accommodations, please call or email the Office of Disability Resources, (914) 251-6035, odr@purchase.edu.

## Mental Health

I understand that this is a challenging and stressful time. Please check the [Counseling Center's website](https://www.purchase.edu/counseling-center/index.php) to learn about the various services that the Counseling Center has to offer, including remote counseling, emergency resources, hotlines, and referrals. Take care of your mental health!

## Course Outline (Tentative)

| Week | Topics | Readings |
| ---- | ------ | -------- |
| 1 (1/31, 2/3) | Intro to the course; Proofs and Set theory; LaTeX | Chapter 0 and LaTeX handouts |
| 2 (2/7, 2/10) | DFAs, NFAs, Closure Properties | Section 1.1 - 1.2 |
| 3 (2/14, 2/17) | NFAs and Closure Properties | Sections 1.2 - 1.3; **Quiz 1** |
| 4 (2/21, 2/24) | Regular Expressions and Non-Regular Languages | Sections 1.3 - 1.4 |
| 5 (2/28, 3/3) | Context-Free Grammars and Pushdown Automata | Sections 2.1 - 2.2 |
| 6 (3/7, 3/10) | Pushdown Automata and Intro to Turing Machines | Sections 2.2, 3.1; **Quiz 2** |
| 7 (3/14, 3/17) | Describing Turing Machines, Variants of TMs, and Church's Thesis | Sections 3.1 - 3.3 |
| 8 (3/21, 3/24) | Review of Set Theory and Diagonalization | Section 4.1 |
| 9 (3/28, 3/31) | Undecidability | Sections 4.1 - 4.2; **Take home exam?** |
| 10 (4/4, 4/7) | Reducibility | Sections 5.1 - 5.3 |
| 11 (**spring break**) | No classes  |  |
| 12 (4/18, 4/21) | Complexity Theory and P vs NP | 7.1 - 7.3 |
| 13 (4/25, 4/28) | NP-Completeness; Introduction to Logic | Sections 7.4 - 7.5; 6.1 - 6.2; **Quiz 3** |
| 14 (5/2, 5/5) | Logic, arithmetic, and the undefinability of truth | Section 6.2 |
| 15 (5/9, 5/12) | Final Presentations | |

This is very much subject to change.
