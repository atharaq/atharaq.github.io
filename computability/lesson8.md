# Computability Lesson 8: Context-free grammars
{:.no_toc}

1. Table of Contents
{:toc}

# Warm-up

Determine if the following languages are regular or not. Prove your answer. Let $\Sigma = \\{ a, b \\}$ for each of these:

1. $\mathcal{L}_1 = \\{ w : $ the length of $w$ is a multiple of 2 $\\}$.
2. $\mathcal{L}_2 = \\{ w : $ the length of $w$ is a power of 2 $\\}$.

(Discuss this with each other. What are your intuitions for each of these?)

## Another non-regular language

Let $\Sigma = \\{ (, ) \\}$, and $\mathcal{L} = \\{ w : w$ is a string of perfectly nested parentheses $\\}$.

For example: $() \in \mathcal{L}$, $()() \in \mathcal{L}$, $(())() \in \ mathcal{L}$, but $)()( \not \in \mathcal{L}$.

**Claim**: $\mathcal{L}$ is not regular.

**Proof**: Assume ([BWOC](https://twitter.com/virtualcourtney/status/1369655632916148232)) it is. Then it has a pumping length $p$. Let $w = (^p)^p$. Since $w \in \mathcal{L}$, there are $x, y, z$ such that $w = xyz$, $\|y\| > 0$ and $\|xy\| \leq p$. Then $y = (^n$ for some $n > 0$. Therefore $xy^2z = (^{p+n})^p$, which is no longer a perfectly nested string of parentheses.

**Alternate proof**: Notice that $\mathcal{L} \cap (^* )^* = \\{ (^n )^n : n \in \mathbb{N} \\}$. This language is not regular, since, if there were a DFA which recognized it, by replacing $($ with $0$ and $)$ with $1$ everywhere in that DFA, we would have a DFA which recognized $\\{ 0^n 1^n \\}$, which we already know is not regular. (This argument can be made more formal, but we won't require that for now.)

# Problem Set Questions

# Grammars

Reading: Sipser 2.1 / M-S 3.1 - 3.3

Informally, a **grammar** is a set of rules for combining words together to form "sentences". A grammar naturally corresponds to a language: if $G$ is a grammar, the $\mathcal{L}(G)$ is the set of valid strings according to the grammar $G$.

**Example**: Consider $\Sigma = \\{ (, ) \\}$, and let $G$ be the grammar given by the following rules:

$$
\begin{align}
S \rightarrow SS | ( S ) | \varepsilon
\end{align}
$$

$S$ is a **variable** (the "start variable"). '(' and ')' are **terminals**. $S \rightarrow SS$ is a **production rule** (one of the rules of the grammar). A string is **valid** according to the grammar (ie, a string is in the language $\mathcal{L}(G)$) if there is some way of "deriving" that string from the start variable, using those production rules. For example:

$$S \implies SS \implies (S) S \implies ((S))S \implies (()) S \implies (()) (S) \implies (()) () \in \mathcal{L}(G)$$

## Formal Description

# Design Examples
