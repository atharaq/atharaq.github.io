# Computability Lesson 19 Solutions

# Hand in 1:

Consider the language FIN = $\\{ \langle M \rangle : \mathcal{L}(M)$ is finite $\\}$. Show that $A_{TM} \leq_m \overline{FIN}$.

**Solution**: 

We need to design a computable function such that, on input $\langle M, w \rangle$, we output a TM $\langle M^\prime \rangle$ where, if $M$ accepts $w$, then $\mathcal{L}(M^\prime)$ is infinite, and if $M$ does not accept $w$, $M^\prime$ is finite. In fact what we will do is make $\mathcal{L}(M^\prime)$ either everything ($\Sigma^*$) or nothing ($\emptyset$)!

"On input $\langle M, w\rangle$:
1. Construct $M^\prime$, which operates as follows:
   * 'On input x:
   * Run M on w (**not x**!)
   * If M accepts w, accept (ie, $M^\prime$ accepts x).
   * If M rejects w, reject.'
2. Output $M^\prime$."

Now: if $M$ accepts $w$, then $M^\prime$ accepts every input $x$ so its language is infinite. If $M$ runs forever on $w$, then $M^\prime$ runs forever on every input $x$, and so its language is the empty set (which is finite). If $M$ rejects $w$, $M^\prime$ rejects every input, so its language is again finite.

# Hand in 2

TOT = $\\{ \langle F \rangle : F$ is a total computable function $\\}$. Hint: $F$ is total computable means for every $w$, there is some step $s$ such that $F$ halts on input $w$ after $s$ steps. Translate this into logic!

**Solution**: $\langle F \rangle \in TOT$ if and only if $\forall w \exists s$  "$F(w)$ halts in $s$ steps.".

Note that "$F(w)$ halts in $s$ steps" is computable! That is, if you are given inputs $F$, $w$, and $s$, we can run the computation of $F$ on input $w$ for $s$ steps and check if it reached either an accepting or rejecting configuration.

# Hand in 3

Consider the following "implementation-level" description of an algorithm, with $\Sigma = \\{ 0, 1 \\}$

"On input $w$:
1. If $w = \varepsilon$, reject.
2. If $w$ starts with $0$, reject. Otherwise, replace the first bit (1) with a "marked" 1 ($\dot{1}$).
3. Scan to the end of the tape.
4. Repeat:
   * Look at the rightmost bit.
   * If it is $0$, replace it with a blank and move left.
   * If it is $1$, reject.
   * If we get to the beginning of the tape (look for the dotted symbol), accept."

Answer the following:

1. Does this algorithm accept or reject $w = 101000$?
2. Suppose $w$ has length $n$. What is the running time of this algorithm in terms of $n$?

**Solution** to 1:

* The machine replaces $1$ with $\dot{1}$ and then scans to the end of the tape (tape = $\dot{1}01000$).
* It enters the loop:
  * Tape = $\dot{1}0100$.
  * Tape = $\dot{1}010$.
  * Tape = $\dot{1}01$.
  * Rightmost bit is now 1, so it rejects

**Solution to 2**:

For an input of length $n$, the maximum number of steps it will take is $O(n)$. This is because it will do the following:

* Check if the first symbol is blank. (reject)
* Check if the first symbol is 0. (reject)
* Replace the first 1 with a marked 1.
* Scan to the end of the tape (n steps)
* Repeat the following:
  * Check if the last bit is 1 (reject)
  * Check if we see the dotted 1 (accept)
  * Delete the last bit and move left

That last repetition can take at most n steps again. So the total running time is roughly 2n + 1, or $O(n)$.