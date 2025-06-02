# Lernzettel: Vektoren (Abitur NRW)

## 1. Was ist ein Vektor?
Ein Vektor ist eine gerichtete Größe im Raum, die durch Richtung und Betrag (Länge) beschrieben wird.  
**Beispiel:** Eine Verschiebung von Punkt $A$ nach $B$.

**Darstellung:**
- **Koordinatenform:** $\vec{a} = \begin{pmatrix} a_1 \\ a_2 \\ a_3 \end{pmatrix}$
- **Pfeilform:** $\vec{AB} = \begin{pmatrix} b_1 - a_1 \\ b_2 - a_2 \\ b_3 - a_3 \end{pmatrix}$

---

## 2. Rechnen mit Vektoren

### Addition & Subtraktion
- **Addition:** $\vec{a} + \vec{b} = \begin{pmatrix} a_1 + b_1 \\ a_2 + b_2 \\ a_3 + b_3 \end{pmatrix}$
- **Subtraktion:** $\vec{a} - \vec{b} = \begin{pmatrix} a_1 - b_1 \\ a_2 - b_2 \\ a_3 - b_3 \end{pmatrix}$
- **Geometrische Bedeutung:** Parallelogrammregel

**Beispiel:**  
$\vec{a} = \begin{pmatrix} 1 \\ 2 \\ 3 \end{pmatrix}$, $\vec{b} = \begin{pmatrix} 2 \\ 0 \\ -1 \end{pmatrix}$  
$\vec{a} + \vec{b} = \begin{pmatrix} 3 \\ 2 \\ 2 \end{pmatrix}$

### Multiplikation mit einer Zahl (Skalierung)
$\lambda \cdot \vec{a} = \begin{pmatrix} \lambda a_1 \\ \lambda a_2 \\ \lambda a_3 \end{pmatrix}$  
- **Streckt** ($\lambda > 1$) oder **staucht** ($0 < \lambda < 1$) den Vektor, bei negativem $\lambda$ Umkehr der Richtung.

---

## 3. Betrag (Länge) eines Vektors
$|\vec{a}| = \sqrt{a_1^2 + a_2^2 + a_3^2}$  
- **Bedeutung:** Abstand vom Ursprung zum Punkt $(a_1, a_2, a_3)$.

**Beispiel:**  
$\vec{a} = \begin{pmatrix} 3 \\ 4 \\ 0 \end{pmatrix} \implies |\vec{a}| = 5$

---

## 4. Skalarprodukt (inneres Produkt)
$\vec{a} \cdot \vec{b} = a_1 b_1 + a_2 b_2 + a_3 b_3$  
- **Ergebnis:** Zahl (Skalar)
- **Orthogonalität:** $\vec{a} \cdot \vec{b} = 0 \implies$ Vektoren stehen senkrecht zueinander.
- **Winkel:** $\cos(\alpha) = \dfrac{\vec{a} \cdot \vec{b}}{|\vec{a}| \cdot |\vec{b}|}$

**Beispiel:**  
$\vec{a} = \begin{pmatrix} 1 \\ 0 \\ 0 \end{pmatrix}$, $\vec{b} = \begin{pmatrix} 0 \\ 1 \\ 0 \end{pmatrix}$  
$\vec{a} \cdot \vec{b} = 0$ (orthogonal)

---

## 5. Vektorprodukt (Kreuzprodukt, nur im $\mathbb{R}^3$)
$\vec{a} \times \vec{b} = \begin{pmatrix} a_2 b_3 - a_3 b_2 \\ a_3 b_1 - a_1 b_3 \\ a_1 b_2 - a_2 b_1 \end{pmatrix}$  
- **Ergebnis:** Vektor senkrecht auf $\vec{a}$ und $\vec{b}$
- **Betrag:** Fläche des Parallelogramms, das von $\vec{a}$ und $\vec{b}$ aufgespannt wird.

**Beispiel:**  
$\vec{a} = \begin{pmatrix} 1 \\ 0 \\ 0 \end{pmatrix}$, $\vec{b} = \begin{pmatrix} 0 \\ 1 \\ 0 \end{pmatrix}$  
$\vec{a} \times \vec{b} = \begin{pmatrix} 0 \\ 0 \\ 1 \end{pmatrix}$

---

## 6. Geradengleichungen

**Punkt-Richtungs-Form:**  
$\vec{g}(t) = \vec{p} + t \cdot \vec{r}$  
- $\vec{p}$: Stützvektor (Punkt auf der Geraden)
- $\vec{r}$: Richtungsvektor
- $t \in \mathbb{R}$: Parameter

**Beispiel:**  
Gerade durch $A(1,2,3)$ mit Richtung $\vec{r} = \begin{pmatrix} 2 \\ -1 \\ 0 \end{pmatrix}$:  
$\vec{g}(t) = \begin{pmatrix} 1 \\ 2 \\ 3 \end{pmatrix} + t \begin{pmatrix} 2 \\ -1 \\ 0 \end{pmatrix}$

---

## 7. Ebenengleichungen

**Parameterform:**  
$\vec{E}(s, t) = \vec{p} + s \cdot \vec{r}_1 + t \cdot \vec{r}_2$  
- $\vec{p}$: Stützvektor (Punkt auf der Ebene)
- $\vec{r}_1, \vec{r}_2$: Spannvektoren (Richtungen in der Ebene)
- $s, t \in \mathbb{R}$

**Normalenform:**  
$(\vec{x} - \vec{p}) \cdot \vec{n} = 0$  
- $\vec{n}$: Normalenvektor (senkrecht zur Ebene)

**Koordinatenform:**  
$ax + by + cz = d$  
- Umwandlung aus der Normalenform möglich.

---

## 8. Lagebeziehungen

- **Geraden schneiden sich:** Gleichungssystem aufstellen, gemeinsamen Punkt finden.
- **Geraden parallel:** Richtungsvektoren sind Vielfache voneinander.
- **Geraden windschief:** Kein Schnittpunkt, nicht parallel.
- **Gerade und Ebene:** Geradengleichung in Ebenengleichung einsetzen, Parameter bestimmen.
- **Ebenen parallel:** Normalenvektoren sind Vielfache.
- **Ebenen identisch:** Ebenengleichungen stimmen überein.

---

## 9. Abstand

- **Punkt zu Gerade:**  
$d = \dfrac{|\left(\vec{AP} \times \vec{r}\right)|}{|\vec{r}|}$  
$\vec{AP}$: Verbindungsvektor von Punkt $A$ (auf der Geraden) zu Punkt $P$ (außerhalb)

- **Punkt zu Ebene:**  
$d = \dfrac{|(\vec{p} - \vec{q}) \cdot \vec{n}|}{|\vec{n}|}$  
$\vec{p}$: Punkt außerhalb, $\vec{q}$: Punkt auf der Ebene, $\vec{n}$: Normalenvektor

- **Gerade zu Gerade (windschief):**  
$d = \dfrac{|(\vec{p}_2 - \vec{p}_1) \cdot (\vec{r}_1 \times \vec{r}_2)|}{|\vec{r}_1 \times \vec{r}_2|}$

---

## 10. Tipps & Tricks

- **Skizzen helfen!** Zeichne dir Situationen zur besseren Vorstellung.
- **Einheiten beachten:** Besonders bei Längen und Abständen.
- **Gleichungssysteme üben:** Viele Aufgaben laufen darauf hinaus.
- **Vektoren normieren:** Manchmal ist ein Einheitsvektor hilfreich: $\vec{e} = \frac{\vec{a}}{|\vec{a}|}$
- **Prüfe Ergebnisse:** Sind sie plausibel? Stimmen Richtungen und Beträge?

---

**Viel Erfolg beim Lernen!**
