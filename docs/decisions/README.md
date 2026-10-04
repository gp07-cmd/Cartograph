# Architecture Decision Records

Cartograph records choices that are expensive to reverse or easy to
re-litigate on vibes — the store choice, concurrency model, stack pins —
as numbered ADRs.

## Conventions

- File name: `NNNN-short-name.md`, numbered sequentially.
- Status vocabulary: **Proposed → Accepted**, later **Superseded** by a newer ADR.
- Every ADR states its **triggers to revisit** — the observable facts that
  reopen the decision. Feelings are not triggers.
- Superseding an ADR means writing the new one and marking the old status;
  never delete history.

## Index

| ADR | Decision | Status |
|---|---|---|
| [0001 — SQLite over Postgres for the v1 graph store](0001-sqlite-over-postgres.md) | Embedded SQLite through v1; Postgres at a named trigger (multi-instance state, pgvector, managed HA) | Accepted (2026-10-03) |

## Template

Copy [`template.md`](template.md) when writing the next record.
