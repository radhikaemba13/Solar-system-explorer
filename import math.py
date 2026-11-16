import math
import random
import tkinter as tk
from tkinter import ttk, messagebox

# ---------------------------------------------------------------- data
PLANETS = [
    {"name": "Mercury", "color": "#b1b1b1", "type": "Terrestrial", "diameter": 4879,
     "distance": 57.9, "day": "58.6 Earth days", "year": "88 Earth days", "moons": 0,
     "temp": "-180 to 430 C",
     "fact": "Mercury is the smallest planet and has almost no atmosphere, so "
             "temperatures swing wildly between day and night."},
    {"name": "Venus", "color": "#e6c27a", "type": "Terrestrial", "diameter": 12104,
     "distance": 108.2, "day": "243 Earth days", "year": "225 Earth days", "moons": 0,
     "temp": "about 465 C",
     "fact": "Venus is the hottest planet thanks to a thick CO2 atmosphere, and "
             "it spins backwards compared with most planets."},
    {"name": "Earth", "color": "#4f9de0", "type": "Terrestrial", "diameter": 12756,
     "distance": 149.6, "day": "24 hours", "year": "365.25 days", "moons": 1,
     "temp": "-88 to 58 C",
     "fact": "Earth is the only known world with liquid water on its surface "
             "and the only one known to support life."},
    {"name": "Mars", "color": "#d1583a", "type": "Terrestrial", "diameter": 6792,
     "distance": 227.9, "day": "24.6 hours", "year": "687 Earth days", "moons": 2,
     "temp": "-125 to 20 C",
     "fact": "Mars hosts Olympus Mons, the tallest volcano in the solar system, "
             "at roughly three times the height of Mount Everest."},
    {"name": "Jupiter", "color": "#d9a066", "type": "Gas giant", "diameter": 142984,
     "distance": 778.5, "day": "9.9 hours", "year": "11.9 Earth years", "moons": 95,
     "temp": "about -110 C (cloud tops)",
     "fact": "Jupiter is more than twice as massive as all the other planets "
             "combined, and its Great Red Spot is a storm older than 150 years."},
    {"name": "Saturn", "color": "#e3d08f", "type": "Gas giant", "diameter": 120536,
     "distance": 1432.0, "day": "10.7 hours", "year": "29.5 Earth years", "moons": 146,
     "temp": "about -140 C (cloud tops)",
     "fact": "Saturn's rings are made mostly of ice particles and span up to "
             "282,000 km, yet are often only about 10 metres thick."},
    {"name": "Uranus", "color": "#8fd8dc", "type": "Ice giant", "diameter": 51118,
     "distance": 2867.0, "day": "17.2 hours", "year": "84 Earth years", "moons": 28,
     "temp": "about -195 C",
     "fact": "Uranus rotates on its side, tilted about 98 degrees, so its poles "
             "get sunlight for decades at a time."},
    {"name": "Neptune", "color": "#4062d8", "type": "Ice giant", "diameter": 49528,
     "distance": 4515.0, "day": "16.1 hours", "year": "165 Earth years", "moons": 16,
     "temp": "about -200 C",
     "fact": "Neptune has the fastest winds in the solar system, measured at "
             "over 2,000 km/h."},
]

BG = "#0b1026"
PANEL = "#141b3c"
ACCENT = "#ffb703"
TEXT = "#e8ecff"
MUTED = "#8f9bc7"


# ---------------------------------------------------------------- app
class SolarApp(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Solar System Explorer")
        self.geometry("1000x640")
        self.minsize(900, 580)
        self.configure(bg=BG)

        self._style()
        self._header()

        nb = ttk.Notebook(self)
        nb.pack(fill="both", expand=True, padx=14, pady=(0, 14))

        self.explore_tab = tk.Frame(nb, bg=BG)
        self.quiz_tab = tk.Frame(nb, bg=BG)
        nb.add(self.explore_tab, text="  Explore  ")
        nb.add(self.quiz_tab, text="  Quiz  ")

        self.angles = [random.uniform(0, 2 * math.pi) for _ in PLANETS]
        self.selected = 2  # Earth
        self.paused = False

        self._build_explore()
        self._build_quiz()
        self._select(self.selected)
        self._animate()

    # ---- styling
    def _style(self):
        s = ttk.Style(self)
        s.theme_use("clam")
        s.configure("TNotebook", background=BG, borderwidth=0)
        s.configure("TNotebook.Tab", background=PANEL, foreground=MUTED,
                    padding=(14, 8), font=("Segoe UI", 11, "bold"))
        s.map("TNotebook.Tab",
              background=[("selected", ACCENT)],
              foreground=[("selected", "#1a1a1a")])
        s.configure("Accent.TButton", background=ACCENT, foreground="#1a1a1a",
                    font=("Segoe UI", 10, "bold"), padding=8, borderwidth=0)
        s.map("Accent.TButton", background=[("active", "#ffc933")])

    def _header(self):
        bar = tk.Frame(self, bg=BG)
        bar.pack(fill="x", padx=18, pady=(14, 8))
        tk.Label(bar, text="Solar System Explorer", bg=BG, fg=TEXT,
                 font=("Segoe UI", 22, "bold")).pack(side="left")
        tk.Label(bar, text="  eight worlds, one star", bg=BG, fg=MUTED,
                 font=("Segoe UI", 12)).pack(side="left", pady=(10, 0))

    # ---- explore tab
    def _build_explore(self):
        left = tk.Frame(self.explore_tab, bg=PANEL, width=170)
        left.pack(side="left", fill="y", padx=(0, 10), pady=4)
        left.pack_propagate(False)
        tk.Label(left, text="PLANETS", bg=PANEL, fg=MUTED,
                 font=("Segoe UI", 9, "bold")).pack(anchor="w", padx=14, pady=(12, 6))

        self.list_buttons = []
        for i, p in enumerate(PLANETS):
            b = tk.Label(left, text="  " + p["name"], anchor="w", bg=PANEL, fg=TEXT,
                         font=("Segoe UI", 12), cursor="hand2", pady=6)
            b.pack(fill="x", padx=6)
            b.bind("<Button-1>", lambda e, idx=i: self._select(idx))
            self.list_buttons.append(b)

        right = tk.Frame(self.explore_tab, bg=BG)
        right.pack(side="left", fill="both", expand=True, pady=4)

        # orbit canvas
        self.canvas = tk.Canvas(right, bg="#070b1d", height=300, highlightthickness=0)
        self.canvas.pack(fill="x")
        self.canvas.bind("<Button-1>", self._canvas_click)
        random.seed(7)
        self.stars = [(random.random(), random.random(), random.choice([1, 1, 2]))
                      for _ in range(90)]

        ctrl = tk.Frame(right, bg=BG)
        ctrl.pack(fill="x", pady=6)
        self.pause_btn = ttk.Button(ctrl, text="Pause orbits", style="Accent.TButton",
                                    command=self._toggle_pause)
        self.pause_btn.pack(side="left")
        tk.Label(ctrl, text="Tip: click a planet in the orbit view to select it",
                 bg=BG, fg=MUTED, font=("Segoe UI", 9)).pack(side="left", padx=12)

        # info card
        card = tk.Frame(right, bg=PANEL)
        card.pack(fill="both", expand=True)
        self.name_lbl = tk.Label(card, bg=PANEL, fg=ACCENT, font=("Segoe UI", 20, "bold"))
        self.name_lbl.pack(anchor="w", padx=16, pady=(12, 0))
        self.type_lbl = tk.Label(card, bg=PANEL, fg=MUTED, font=("Segoe UI", 10))
        self.type_lbl.pack(anchor="w", padx=16)

        grid = tk.Frame(card, bg=PANEL)
        grid.pack(fill="x", padx=16, pady=10)
        self.stat_vals = {}
        stats = [("Diameter", "diameter"), ("Distance from Sun", "distance"),
                 ("Day length", "day"), ("Year length", "year"),
                 ("Moons", "moons"), ("Temperature", "temp")]
        for n, (label, key) in enumerate(stats):
            r, c = divmod(n, 3)
            cell = tk.Frame(grid, bg=PANEL)
            cell.grid(row=r, column=c, sticky="w", padx=(0, 28), pady=4)
            tk.Label(cell, text=label.upper(), bg=PANEL, fg=MUTED,
                     font=("Segoe UI", 8, "bold")).pack(anchor="w")
            v = tk.Label(cell, bg=PANEL, fg=TEXT, font=("Segoe UI", 12, "bold"))
            v.pack(anchor="w")
            self.stat_vals[key] = v

        self.fact_lbl = tk.Label(card, bg=PANEL, fg=TEXT, font=("Segoe UI", 11),
                                 wraplength=640, justify="left")
        self.fact_lbl.pack(anchor="w", padx=16, pady=(4, 12))

    def _select(self, idx):
        self.selected = idx
        p = PLANETS[idx]
        for i, b in enumerate(self.list_buttons):
            b.configure(bg=ACCENT if i == idx else PANEL,
                        fg="#1a1a1a" if i == idx else TEXT)
        self.name_lbl.configure(text=p["name"])
        self.type_lbl.configure(text=p["type"])
        self.stat_vals["diameter"].configure(text=f"{p['diameter']:,} km")
        self.stat_vals["distance"].configure(text=f"{p['distance']:,} million km")
        self.stat_vals["day"].configure(text=p["day"])
        self.stat_vals["year"].configure(text=p["year"])
        self.stat_vals["moons"].configure(text=str(p["moons"]))
        self.stat_vals["temp"].configure(text=p["temp"])
        self.fact_lbl.configure(text=p["fact"])

    # ---- orbit animation
    def _positions(self):
        w = max(self.canvas.winfo_width(), 600)
        h = max(self.canvas.winfo_height(), 300)
        cx, cy = w / 2, h / 2
        max_rx, max_ry = w / 2 - 20, h / 2 - 12
        out = []
        for i in range(len(PLANETS)):
            f = (i + 1.6) / (len(PLANETS) + 0.6)
            rx, ry = max_rx * f, max_ry * f
            a = self.angles[i]
            out.append((cx + rx * math.cos(a), cy + ry * math.sin(a), rx, ry))
        return cx, cy, out

    def _animate(self):
        c = self.canvas
        c.delete("all")
        w, h = max(c.winfo_width(), 600), max(c.winfo_height(), 300)
        for sx, sy, sz in self.stars:
            c.create_oval(sx * w, sy * h, sx * w + sz, sy * h + sz, fill="#5b6697", outline="")
        cx, cy, pos = self._positions()
        c.create_oval(cx - 18, cy - 18, cx + 18, cy + 18, fill="#ffcc33", outline="#ff9d00", width=3)
        for i, (x, y, rx, ry) in enumerate(pos):
            c.create_oval(cx - rx, cy - ry, cx + rx, cy + ry,
                          outline=ACCENT if i == self.selected else "#232c5a")
            r = 4 + min(PLANETS[i]["diameter"] / 142984 * 10, 10)
            if i == self.selected:
                c.create_oval(x - r - 4, y - r - 4, x + r + 4, y + r + 4, outline=ACCENT, width=2)
            c.create_oval(x - r, y - r, x + r, y + r, fill=PLANETS[i]["color"], outline="")
            if i == self.selected:
                c.create_text(x, y - r - 12, text=PLANETS[i]["name"], fill=TEXT,
                              font=("Segoe UI", 9, "bold"))
        if not self.paused:
            for i in range(len(PLANETS)):
                self.angles[i] += 0.035 / (1 + i * 0.55)
        self.after(40, self._animate)

    def _canvas_click(self, e):
        _, _, pos = self._positions()
        best, best_d = None, 20
        for i, (x, y, _, _) in enumerate(pos):
            d = math.hypot(e.x - x, e.y - y)
            if d < best_d:
                best, best_d = i, d
        if best is not None:
            self._select(best)

    def _toggle_pause(self):
        self.paused = not self.paused
        self.pause_btn.configure(text="Resume orbits" if self.paused else "Pause orbits")

    # ---- quiz tab
    def _build_quiz(self):
        f = self.quiz_tab
        self.q_progress = tk.Label(f, bg=BG, fg=MUTED, font=("Segoe UI", 10, "bold"))
        self.q_progress.pack(anchor="w", padx=20, pady=(16, 0))
        self.q_text = tk.Label(f, bg=BG, fg=TEXT, font=("Segoe UI", 18, "bold"),
                               wraplength=820, justify="left")
        self.q_text.pack(anchor="w", padx=20, pady=(6, 14))

        self.opt_var = tk.IntVar(value=-1)
        self.opt_buttons = []
        for i in range(4):
            rb = tk.Radiobutton(f, variable=self.opt_var, value=i, anchor="w",
                                bg=PANEL, fg=TEXT, selectcolor=BG, activebackground=PANEL,
                                activeforeground=ACCENT, font=("Segoe UI", 13),
                                indicatoron=False, padx=14, pady=10, relief="flat",
                                command=lambda: None)
            rb.pack(fill="x", padx=20, pady=4)
            self.opt_buttons.append(rb)

        self.feedback = tk.Label(f, bg=BG, fg=ACCENT, font=("Segoe UI", 12, "bold"))
        self.feedback.pack(anchor="w", padx=20, pady=10)

        row = tk.Frame(f, bg=BG)
        row.pack(anchor="w", padx=20)
        self.submit_btn = ttk.Button(row, text="Submit", style="Accent.TButton",
                                     command=self._submit)
        self.submit_btn.pack(side="left")
        ttk.Button(row, text="Restart quiz", style="Accent.TButton",
                   command=self._new_quiz).pack(side="left", padx=10)
        self._new_quiz()

    def _make_questions(self):
        qs = []
        names = [p["name"] for p in PLANETS]
        templates = [
            ("Which planet is the largest?", max(PLANETS, key=lambda p: p["diameter"])["name"]),
            ("Which planet is the smallest?", min(PLANETS, key=lambda p: p["diameter"])["name"]),
            ("Which planet is closest to the Sun?", "Mercury"),
            ("Which planet is the hottest, thanks to its thick atmosphere?", "Venus"),
            ("Which planet has the most moons?", max(PLANETS, key=lambda p: p["moons"])["name"]),
            ("Which planet is famous for its Great Red Spot storm?", "Jupiter"),
            ("Which planet spins on its side, tilted about 98 degrees?", "Uranus"),
            ("Which planet has the fastest winds in the solar system?", "Neptune"),
            ("Which planet hosts Olympus Mons, the tallest volcano?", "Mars"),
            ("Which planet has the longest day (one spin)?", "Venus"),
            ("Which planet has a year lasting about 88 Earth days?", "Mercury"),
            ("Which planet is the only one known to support life?", "Earth"),
        ]
        random.shuffle(templates)
        for q, ans in templates[:8]:
            wrong = random.sample([n for n in names if n != ans], 3)
            opts = wrong + [ans]
            random.shuffle(opts)
            qs.append((q, opts, opts.index(ans)))
        return qs

    def _new_quiz(self):
        self.questions = self._make_questions()
        self.qi = 0
        self.score = 0
        self.answered = False
        self.submit_btn.configure(text="Submit")
        self._show_question()

    def _show_question(self):
        q, opts, _ = self.questions[self.qi]
        self.q_progress.configure(text=f"QUESTION {self.qi + 1} OF {len(self.questions)}   |   SCORE {self.score}")
        self.q_text.configure(text=q)
        self.opt_var.set(-1)
        for rb, o in zip(self.opt_buttons, opts):
            rb.configure(text=o, bg=PANEL, state="normal")
        self.feedback.configure(text="")
        self.answered = False
        self.submit_btn.configure(text="Submit")

    def _submit(self):
        if self.answered:  # move on
            self.qi += 1
            if self.qi >= len(self.questions):
                messagebox.showinfo("Quiz complete",
                                    f"You scored {self.score} out of {len(self.questions)}.")
                self._new_quiz()
            else:
                self._show_question()
            return
        choice = self.opt_var.get()
        if choice < 0:
            self.feedback.configure(text="Pick an answer first.")
            return
        _, opts, correct = self.questions[self.qi]
        self.answered = True
        if choice == correct:
            self.score += 1
            self.feedback.configure(text="Correct!", fg="#6be675")
        else:
            self.feedback.configure(text=f"Not quite - the answer is {opts[correct]}.", fg="#ff7b7b")
        self.opt_buttons[correct].configure(bg="#1f6b3a")
        if choice != correct:
            self.opt_buttons[choice].configure(bg="#7a2a2a")
        for rb in self.opt_buttons:
            rb.configure(state="disabled")
        last = self.qi == len(self.questions) - 1
        self.submit_btn.configure(text="Finish" if last else "Next question")


if __name__ == "__main__":
    SolarApp().mainloop()
