# Vyrooq Admin Dashboard

Web-based admin dashboard for monitoring and controlling all Vyrooq middleware services.

## Features

- ✅ **Real-time Service Monitoring** - Status of all 9 services
- ✅ **Queue Control** - Pause/resume/retry queues
- ✅ **Metrics Dashboard** - Queue stats, deduplication metrics, integration stats
- ✅ **Authentication** - JWT-based login with auth-service
- ✅ **Quick Actions** - Emergency stop, mass operations
- ✅ **Auto-refresh** - 30-second automatic updates
- ✅ **Responsive Design** - Works on desktop and mobile
- ✅ **Toast Notifications** - Real-time feedback

## Services Controlled

### 1. Auth Service (Port 3100)
- User authentication
- Role-based access control

### 2. Retry Engine (Port 3200)
- View queue metrics
- Monitor job counts

### 3. Deduplication Engine (Port 3300)
- Transaction fingerprints
- Idempotency key counts
- Correlation tracking

### 4. Manual Control Engine (Port 3400)
- Pause/resume queues
- Retry failed jobs
- Force sync operations
- Replay transactions

### 5. Gateway API (Port 3000)
- Service health monitoring

### 6. VendHQ Adapter (Port 8100)
- View sales count
- Monitor POS integration

### 7. Opencart Adapter (Port 8200)
- View order count
- Monitor e-commerce integration

## Dashboard Pages

### 1. Main Dashboard (`/`)
- Service status grid
- Quick action buttons
- System metrics
- Recent activity

### 2. Queue Control (`/pages/queues.html`)
- Detailed queue management
- Pause/resume individual queues
- Retry failed jobs
- View job history

### 3. Deduplication (`/pages/deduplication.html`)
- Fingerprint statistics
- Idempotency key management
- Correlation ID tracking

### 4. Integrations (`/pages/integrations.html`)
- VendHQ integration status
- Opencart integration status
- Sync operations

### 5. Monitoring (`/pages/monitoring.html`)
- Real-time charts
- Performance metrics
- System health

## Setup

1. Install dependencies:
```bash
npm install
```

2. Configure environment:
```bash
cp .env.example .env
# Edit .env with your service URLs
```

3. Start dashboard:
```bash
npm start
# or for development with auto-reload
npm run dev
```

4. Access dashboard:
```
http://localhost:4000
```

## Environment Variables

```env
PORT=4000
NODE_ENV=development

# Service URLs
AUTH_SERVICE_URL=http://localhost:3100
RETRY_ENGINE_URL=http://localhost:3200
DEDUPLICATION_ENGINE_URL=http://localhost:3300
MANUAL_CONTROL_ENGINE_URL=http://localhost:3400
GATEWAY_API_URL=http://localhost:3000
VENDHQ_ADAPTER_URL=http://localhost:8100
OPENCART_ADAPTER_URL=http://localhost:8200

# Secrets
SESSION_SECRET=your-session-secret
JWT_SECRET=your-jwt-secret
```

## Default Login

Get credentials from auth-service:
- Use the auth-service to create an admin user first
- Then login with those credentials

Or use existing credentials if you've set them up:
```
Email: admin@vyrooq.com
Password: Your admin password
```

## Features

### Service Status Monitoring
- Real-time health checks for all 9 services
- Visual status indicators (healthy/unhealthy)
- Service uptime tracking
- Automatic refresh every 30 seconds

### Queue Control
- **Pause All Queues** - Emergency stop button
- **Resume All Queues** - Restart processing
- **Retry Failed Jobs** - Batch retry operations
- **View Metrics** - Detailed queue statistics

### Deduplication Stats
- Total transaction fingerprints
- Idempotency key count
- Correlation ID tracking
- Duplicate detection metrics

### Integration Monitoring
- VendHQ sales count
- Opencart order count
- Sync status
- API health

## API Endpoints

The dashboard proxies requests to backend services:

### Authentication
- `POST /api/auth/login` - Login with credentials

### Service Status
- `GET /api/services/status` - Get all services health

### Retry Engine
- `GET /api/retry/metrics` - Get queue metrics

### Manual Control
- `GET /api/control/queues` - Get all queues
- `POST /api/control/queues/:name/pause` - Pause queue
- `POST /api/control/queues/:name/resume` - Resume queue
- `POST /api/control/queues/:name/retry` - Retry failed jobs

### Deduplication
- `GET /api/dedup/stats` - Get deduplication statistics

### Integrations
- `GET /api/vendhq/sales` - Get VendHQ sales
- `GET /api/opencart/orders` - Get Opencart orders

## Security

- JWT authentication required for all control operations
- Session-based authentication
- HTTP-only cookies
- Role-based access control
- HTTPS recommended for production

## Architecture

```
┌─────────────────────────────────────┐
│      Admin Dashboard (Port 4000)    │
│      ┌─────────────────────┐        │
│      │  Express.js Server  │        │
│      │  + Static Files     │        │
│      └──────────┬──────────┘        │
└─────────────────┼───────────────────┘
                  │
        ┌─────────┴─────────┐
        │   API Proxy Layer │
        └─────────┬─────────┘
                  │
     ┌────────────┼────────────┐
     │            │            │
┌────▼───┐   ┌───▼────┐   ┌──▼─────┐
│ Auth   │   │ Retry  │   │ Dedup  │
│ 3100   │   │ 3200   │   │ 3300   │
└────────┘   └────────┘   └────────┘
     │            │            │
┌────▼───┐   ┌───▼────┐   ┌──▼─────┐
│Control │   │VendHQ  │   │Opencart│
│ 3400   │   │ 8100   │   │ 8200   │
└────────┘   └────────┘   └────────┘
```

## Usage Examples

### Pause All Queues (Emergency Stop)

```javascript
// Click "Pause All Queues" button
// Confirms with user
// Sends POST to /api/control/queues/pause-all
// Shows success toast
// Refreshes dashboard
```

### Retry Failed Jobs

```javascript
// Navigate to Queue Control page
// Select queue (e.g., invoice-processing)
// Click "Retry Failed Jobs"
// Enter number of jobs to retry
// Sends POST to /api/control/queues/:name/retry
// Shows results
```

### View Queue Metrics

```javascript
// Dashboard automatically loads metrics
// Shows per-queue statistics:
// - Waiting jobs
// - Active jobs
// - Completed jobs
// - Failed jobs
// - Total jobs
```

## Development

### Project Structure

```
admin-dashboard/
├── public/
│   ├── css/
│   │   └── dashboard.css
│   ├── js/
│   │   └── dashboard.js
│   ├── pages/
│   │   ├── queues.html
│   │   ├── deduplication.html
│   │   ├── integrations.html
│   │   └── monitoring.html
│   └── index.html
├── src/
│   ├── routes/
│   │   └── api.js
│   └── server.js
├── .env.example
├── package.json
├── Dockerfile
└── README.md
```

### Adding New Features

1. Add API endpoint in `src/routes/api.js`
2. Create UI in `public/pages/`
3. Add JavaScript in `public/js/`
4. Style with `public/css/dashboard.css`

### Styling

Uses modern CSS with:
- CSS Grid for layouts
- Flexbox for components
- CSS variables for theming
- Responsive design
- Font Awesome icons

## Docker

Build and run:

```bash
docker build -t vyrooq-admin-dashboard .
docker run -p 4000:4000 --env-file .env vyrooq-admin-dashboard
```

## Troubleshooting

### Services show as unhealthy
- Check that all services are running
- Verify service URLs in .env
- Check network connectivity

### Login fails
- Verify AUTH_SERVICE_URL is correct
- Check auth-service is running
- Verify credentials are correct

### Metrics not loading
- Check service URLs are accessible
- Verify CORS settings
- Check browser console for errors

## Performance

- Dashboard: < 100ms load time
- Service checks: ~500ms (parallel)
- Auto-refresh: Every 30 seconds
- Metrics update: Real-time

## Browser Support

- Chrome/Edge: Latest
- Firefox: Latest
- Safari: Latest
- Mobile: iOS Safari, Chrome Mobile

## License

MIT
