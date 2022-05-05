# Lesson 24: Decision / Search Problems and Turing Jumps
{:.no_toc}

1. Table of Contents
{:toc}

# Upcoming

* Presentation 2 due this Sunday.
* Problem Set 5 will be posted tomorrow and will be due Monday, May 16 (during finals week)
* Final Projects:
  * Topics: ASAP!
  * Presentation: Thursday, 5/12. (about 15 minutes)
  * Paper: Thursday, 5/19. (about 5-10 pages)

Notes are outlined below. [Here is a PDF of a more complete version of my handwritten notes](lesson24.pdf).

# CLIQUE

$CLIQUE = \\{ \langle G, k \rangle : G$ is a graph that has a $k$-clique $\\}$.

A $k$-clique is a set $C \subseteq V$ of vertices such that $\|C\| = k$ and all vertices in $C$ have edges between them.

* Show that $CLIQUE$ has a poly-time verifier.
* Exercise: $3-CLIQUE \in P$.
* CLIQUE is NP-complete.

# Decision vs Search problems

* Decision problem: given $\langle G, k \rangle$, determine if $G$ has a $k$-clique.
* Search problem: given $\langle G, k \rangle$, *find* a subset $C \subseteq V$ such that $C$ is a $k$-clique.
* Example: If the decision problem for CLIQUE is in P, show that there is a polynomial time algorithm that solves the search problem as well.

# Turing Jumps

* Recall: $f : \mathbb{N}^k \to \mathbb{N}$ partial computable if...
* Universal TM: there is a "universal" partial computable $f : \mathbb{N}^2 \to \mathbb{N}$.
  * Instead of referring to $f(e, n)$, we think of this function as a family of (partial computable) functions $f_e(n)$, one for each $e \in \mathbb{N}$.
* A set $A \subseteq \mathbb{N}$ is called computable if its characteristic function $\chi_A$ is
  * $\chi_A : \mathbb{N} \to \\{ 0, 1 \\}$ defined by $\chi_A(x) = 0$ iff $x \not \in A$, $\chi_A(x) = 1$ iff $x \in A$.
* Non-computable set: $X = \\{ e : f_e(e)$ halts and equals 0 $ \\}$.
* $H = \\{ e : f_e(e)$ halts $\\}$ is not computable.
* Given a set $A \subseteq \mathbb{N}$, can define $A$-computability: a function $f$ is $A$-computable if, given access to an oracle for $A$, we can compute $f$.
* $\chi_X$ is $H$-computable.
* Universal "oracle-TM$" $\Phi$, similar to the "universal TM" $f$ above.
* Turing jump of $A$ is the "halting problem relativized to $A$":
  * The set of all those codes of $A$-oracle TMs (ie TMs which have access to an oracle for $A$) which halt on their own input.
  * $\\{ e : \Phi^A_e(e)$ halts $\\}$.
  * Refer to this as $A^\prime$, the "jump" of $A$.
  * Claim: $A <_T A^\prime$.
  * That is: $A^\prime$ can compute $A$, but $A$ cannot compute $A^\prime$.
