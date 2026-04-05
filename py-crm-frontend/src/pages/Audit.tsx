import './Audit.css'

const events = [
  { actor: 'admin@example.com', action: 'Ran job', target: 'VendHQ → Fusion Sales', at: '03:02' },
  { actor: 'ops@example.com', action: 'Updated mapping', target: 'Tax code STANDARD', at: 'Yesterday 19:10' },
  { actor: 'viewer@example.com', action: 'Viewed logs', target: 'Sales job', at: 'Yesterday 14:21' },
]

export const Audit = () => {
  return (
    <div className="audit">
      <div className="header-row">
        <div>
          <p className="eyebrow">Compliance</p>
          <h1>Audit Log</h1>
        </div>
      </div>
      <div className="table-card">
        <div className="table-header">
          <h3>Recent events</h3>
          <span className="muted">Sample data</span>
        </div>
        <table>
          <thead>
            <tr>
              <th>Actor</th>
              <th>Action</th>
              <th>Target</th>
              <th>Time</th>
            </tr>
          </thead>
          <tbody>
            {events.map((e, i) => (
              <tr key={i}>
                <td>{e.actor}</td>
                <td>{e.action}</td>
                <td>{e.target}</td>
                <td>{e.at}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}
