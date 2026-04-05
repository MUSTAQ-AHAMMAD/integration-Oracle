import './Users.css'

const users = [
  { name: 'Admin User', email: 'admin@example.com', role: 'Admin', status: 'Active', lastSeen: 'Today 09:12' },
  { name: 'Ops Manager', email: 'ops@example.com', role: 'Operator', status: 'Active', lastSeen: 'Yesterday 18:33' },
  { name: 'Viewer', email: 'viewer@example.com', role: 'Viewer', status: 'Active', lastSeen: '2 days ago' },
]

export const Users = () => {
  return (
    <div className="users">
      <div className="header-row">
        <div>
          <p className="eyebrow">Access control</p>
          <h1>Users & Roles</h1>
        </div>
        <div className="actions">
          <button className="ghost">Invite user</button>
          <button className="primary">Add role</button>
        </div>
      </div>

      <div className="table-card">
        <div className="table-header">
          <h3>Users</h3>
          <span className="muted">Sample data</span>
        </div>
        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>Email</th>
              <th>Role</th>
              <th>Status</th>
              <th>Last seen</th>
            </tr>
          </thead>
          <tbody>
            {users.map((u) => (
              <tr key={u.email}>
                <td>{u.name}</td>
                <td>{u.email}</td>
                <td>
                  <span className="badge success">{u.role}</span>
                </td>
                <td>
                  <span className="badge success">{u.status}</span>
                </td>
                <td>{u.lastSeen}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      <div className="roles">
        <div className="role-card">
          <h4>Admin</h4>
          <p>Manage users, schedules, mappings, credentials</p>
        </div>
        <div className="role-card">
          <h4>Operator</h4>
          <p>Run jobs, view dashboards, download logs</p>
        </div>
        <div className="role-card">
          <h4>Viewer</h4>
          <p>Read-only dashboards and logs</p>
        </div>
      </div>
    </div>
  )
}
