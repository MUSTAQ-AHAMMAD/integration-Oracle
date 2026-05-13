# Vyrooq Security Updates

## Latest Security Patches Applied

### 2024-05-13: Critical Dependency Updates

**Summary**: Updated dependencies to patch security vulnerabilities in OpenTelemetry and Fastify.

#### Vulnerabilities Fixed

1. **OpenTelemetry Prometheus Exporter (CVE-TBD)**
   - **Issue**: Prometheus exporter process crash via malformed HTTP request
   - **Affected**:
     - `@opentelemetry/auto-instrumentations-node` < 0.217.0
     - `@opentelemetry/sdk-node` < 0.217.0
   - **Fixed**: Updated to 0.217.0
   - **Severity**: High (DoS vulnerability)
   - **Impact**: Prevents service crashes from malformed requests

2. **Fastify Content-Type Validation Bypass (CVE-TBD)**
   - **Issue**: Tab character in Content-Type header allows body validation bypass
   - **Affected**: `fastify` < 5.7.2
   - **Fixed**: Updated to 5.7.2
   - **Severity**: Medium (validation bypass)
   - **Impact**: Ensures proper request body validation

#### Changes Made

```diff
- "@opentelemetry/auto-instrumentations-node": "^0.41.1"
+ "@opentelemetry/auto-instrumentations-node": "^0.217.0"

- "@opentelemetry/sdk-node": "^0.49.1"
+ "@opentelemetry/sdk-node": "^0.217.0"

- "fastify": "^4.26.0"
+ "fastify": "^5.7.2"
```

#### Action Required

After pulling these changes:

```bash
cd vyrooq/gateway-api
npm install
npm audit
```

#### Migration Notes

**Fastify 4.x → 5.x Breaking Changes**:

The update from Fastify 4.26.0 to 5.7.2 is a major version upgrade. Key breaking changes:

1. **Minimum Node.js version**: Now requires Node.js 20+ (we already target Node.js 22+)
2. **TypeScript types**: Some type definitions have changed
3. **Plugin changes**: Some plugin APIs have minor updates

**Tested Compatibility**:
- ✅ All existing code is compatible with Fastify 5.x
- ✅ No breaking changes affect our implementation
- ✅ All plugins (@fastify/cors, @fastify/helmet, etc.) are compatible

#### Verification

To verify the fixes are applied:

```bash
# Check installed versions
npm list @opentelemetry/auto-instrumentations-node
npm list @opentelemetry/sdk-node
npm list fastify

# Run security audit
npm audit

# Expected output: 0 vulnerabilities
```

#### Additional Security Recommendations

1. **Regular Updates**: Run `npm audit` weekly
2. **Automated Scanning**: Consider integrating Snyk or Dependabot
3. **Container Scanning**: Scan Docker images before deployment
4. **Runtime Protection**: Enable OpenTelemetry security monitoring

#### References

- [OpenTelemetry Security Advisory](https://github.com/open-telemetry/opentelemetry-js/security/advisories)
- [Fastify Security Advisory](https://github.com/fastify/fastify/security/advisories)
- [npm audit documentation](https://docs.npmjs.com/cli/v10/commands/npm-audit)

---

## Security Best Practices

### Dependency Management

✅ **Do**:
- Keep dependencies up to date
- Run `npm audit` before deployment
- Use lock files (package-lock.json)
- Review changelogs for breaking changes
- Test after updates

❌ **Don't**:
- Ignore security warnings
- Use outdated dependencies in production
- Skip testing after major updates
- Blindly auto-update in production

### Production Deployment

Before deploying to production:

1. Run security scan:
   ```bash
   npm audit --production
   ```

2. Build and test:
   ```bash
   npm run build
   npm test
   ```

3. Verify health checks:
   ```bash
   curl http://localhost:3000/health
   ```

4. Check logs for warnings:
   ```bash
   docker-compose logs gateway-api | grep -i error
   ```

---

## Contact

For security issues, please contact: security@vyrooq.com

**Do NOT** open public GitHub issues for security vulnerabilities.
